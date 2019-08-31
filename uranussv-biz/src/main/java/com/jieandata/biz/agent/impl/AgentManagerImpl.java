package com.jieandata.biz.agent.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jieandata.biz.agent.AgentManager;
import com.jieandata.biz.base.BaseManagerImpl;
import com.jieandata.dal.dao.AgentInfoMapper;
import com.jieandata.dal.dao.SystemConfigMapper;
import com.jieandata.dal.model.AgentInfoDo;
import com.jieandata.jaguar.common.utils.convert.DateUtils;
import com.jieandata.service.model.agent.AgentInfoConditionVO;
import com.jieandata.service.model.agent.AgentInfoDTO;
import com.jieandata.service.model.agent.AgentInfoVO;
import com.jieandata.service.model.paging.PagingVO;
import com.jieandata.service.verification.IdentityVerifyService;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.constant.Constants;
import com.jieandata.utils.enums.AgentStatEnum;
import com.jieandata.utils.enums.ShareProfitModeEnum;
import com.jieandata.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-8-14 13:55
 * @Description:
 */
@Slf4j
@Service
public class AgentManagerImpl extends BaseManagerImpl implements AgentManager {

    @Autowired
    private IdentityVerifyService identityVerifyService;

    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Override
    public PageInfo<AgentInfoVO> getPagedAgentInfo(PagingVO<AgentInfoConditionVO> paging) {
        if(isAnyNull(paging, paging.getCondition())){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        Map<String, Object> conditions = buildConditions(paging.getCondition());

        PageHelper.startPage(paging.getPageNum(), paging.getPageSize());

        List<AgentInfoDo> agentInfoDoList = agentInfoMapper.getByConditions(conditions);

        PageInfo<AgentInfoDo> pageInfo0 = new PageInfo<>(agentInfoDoList);

        List<AgentInfoVO> agentInfoVOList = buildResults(agentInfoDoList);

        if(isNotNull(agentInfoVOList)){
            PageInfo<AgentInfoVO> pageInfo = new PageInfo<>(agentInfoVOList);

            pageInfo.setTotal(pageInfo0.getTotal());

            return pageInfo;
        }

        return null;
    }

    @Override
    public int saveAgent(AgentInfoDTO agentInfoDTO) {
        if(isAnyNull(agentInfoDTO)){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        AgentInfoDo agentInfoDo = buildAgentInfoDo(agentInfoDTO);

        if(agentInfoDTO.isNew()){
            // insert

            // agentId是否重复
            Map<String, Object> conditions = new HashMap<>();
            conditions.put("agentId", agentInfoDTO.getAgentId());
            List<AgentInfoDo> oldAgentInfoDos = agentInfoMapper.getByConditions(conditions);
            if(isNotNull(oldAgentInfoDos) && oldAgentInfoDos.size() > 0){
                throw new BusinessException(RespCodeEnum.AGENT_ID_USED);
            }
            // agentName是否重复
            conditions.clear();
            conditions.put("agentName", agentInfoDTO.getAgentName());
            oldAgentInfoDos = agentInfoMapper.getByConditions(conditions);
            if(isNotNull(oldAgentInfoDos) && oldAgentInfoDos.size() > 0){
                throw new BusinessException(RespCodeEnum.AGENT_NAME_USED);
            }

            int i = agentInfoMapper.insert(agentInfoDo);
            if(i < 1){
                log.error("添加agentInfo失败", agentInfoDo);
                throw new BusinessException(RespCodeEnum.INSERT_FAIL);
            }else {

                log.info("添加agentInfo成功", agentInfoDo);
                // 异步生成渠道链接
                autoAddLinkurl(agentInfoDTO.getAgentId());
            }
            return i;
        } else {
            // update
            int i = agentInfoMapper.update(agentInfoDo);
            if(i < 1){
                log.error("更新agentInfo失败", agentInfoDo);
                throw new BusinessException(RespCodeEnum.UPDATE_FAIL);
            }else {
                log.info("更新agentInfo成功", agentInfoDo);
            }
            return i;
        }
    }

    /**
     * 异步自动添加渠道链接
     * @param agentId
     */
    @Async
    private int autoAddLinkurl(String agentId) {
        if(isNull(agentId)){
            log.error("autoAddLinkurl error agentId: " + agentId);
            return -1;
        }
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("agentId", agentId);
        List<AgentInfoDo> agentInfoDos = agentInfoMapper.getByConditions(conditions);
        if(CollectionUtils.isEmpty(agentInfoDos)){
            log.error("autoAddLinkurl error, agentInfo is not insert");
            return -1;
        }

        if(agentInfoDos.size() != 1){
            log.error("autoAddLinkurl error, agentInfo is more than 1");
            return -1;
        }

        Integer id = agentInfoDos.get(0).getId();
        String linkurl = buildLinkurl(id);
        if(isAnyNull(id, linkurl)){
            log.error("autoAddLinkurl error, id[{}], linkurl[{}]", id , linkurl);
            return -1;
        }

        AgentInfoDo agentInfoDo = new AgentInfoDo();
        agentInfoDo.setId(id);
        agentInfoDo.setLinkurl(linkurl);

        int i = agentInfoMapper.update(agentInfoDo);
        if(i < 1){
            log.error("更新agentInfo失败", agentInfoDo);
            return -1;
        }else {
            log.info("更新agentInfo成功", agentInfoDo);
        }

        return i;
    }

    private String buildLinkurl(Integer id) {
        if(isNull(id)){
           return null;
        }

        String mainUrl = systemConfigMapper.getValueByKey(Constants.CONFIG_VAL_CHANNEL_MAIN_URL);
        if(isNull(mainUrl)){
            return null;
        }
        return mainUrl + "/?appId=" + id;
    }

    private AgentInfoDo buildAgentInfoDo(AgentInfoDTO agentInfoDTO){
        boolean isNew = agentInfoDTO.isNew();
        AgentInfoDo agentInfoDo = new AgentInfoDo();
        if(isNew){
            // 新增的必填字段
            String agentId = agentInfoDTO.getAgentId();
            if(isNull(agentId) || agentId.length() > 20){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            agentInfoDo.setAgentId(agentId);

            String agentName = agentInfoDTO.getAgentName();
            if(isNull(agentName) || agentName.length() > 50){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            agentInfoDo.setAgentName(agentName);
            // 分润模式
            String shareProfitMode = agentInfoDTO.getShareProfitMode();
            if(isNull(shareProfitMode)){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            ShareProfitModeEnum shareProfitModeEnum = ShareProfitModeEnum.getMatchedEnum(shareProfitMode);
            if(isNull(shareProfitModeEnum)){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            agentInfoDo.setStat(ShareProfitModeEnum.ONLINE.equals(shareProfitModeEnum));
            // 分润比例
            String shareProfitRate = agentInfoDTO.getShareProfitRate();
            if(isNull(shareProfitRate)){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            Float floatRate = Float.valueOf(shareProfitRate);
            if(isNull(floatRate) || floatRate < 0.01 || floatRate > 100){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            agentInfoDo.setShareProfitRate(floatRate);
            // 状态
            String stat = agentInfoDTO.getStat();
            if(isNull(stat)){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            AgentStatEnum agentStatEnum = AgentStatEnum.getMatchedEnum(stat);
            if(isNull(agentStatEnum)){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            agentInfoDo.setStat(AgentStatEnum.OPEN.equals(agentStatEnum));

            agentInfoDo.setAddTime(DateUtils.getSecondTimestamp(DateUtils.getNow()));
        }else{
            // 更新的必填字段
            Integer id = agentInfoDTO.getId();
            if(isNull(id) || id < 1){
                throw new BusinessException(RespCodeEnum.PARAM_ERROR);
            }
            agentInfoDo.setId(id);

            agentInfoDo.setUpdateTime(DateUtils.getSecondTimestamp(DateUtils.getNow()));
            // 非必填字段
            String shareProfitRate = agentInfoDTO.getShareProfitRate();
            if(isNotNull(shareProfitRate)){
                if(!NumberUtils.isCreatable(shareProfitRate)){
                    throw new BusinessException(RespCodeEnum.PARAM_ERROR);
                }
                Float floatRate = Float.valueOf(shareProfitRate);
                if(isNull(floatRate) || floatRate < 0.01 || floatRate > 100){
                    throw new BusinessException(RespCodeEnum.PARAM_ERROR);
                }
                agentInfoDo.setShareProfitRate(floatRate);
            }

            String stat = agentInfoDTO.getStat();
            if(isNotNull(stat)){
                AgentStatEnum agentStatEnum = AgentStatEnum.getMatchedEnum(stat);
                if(isNull(agentStatEnum)){
                    throw new BusinessException(RespCodeEnum.PARAM_ERROR);
                }
                agentInfoDo.setStat(AgentStatEnum.OPEN.equals(agentStatEnum));
            }

            String shareProfitMode = agentInfoDTO.getShareProfitMode();
            if(isNotNull(shareProfitMode)){
                ShareProfitModeEnum shareProfitModeEnum = ShareProfitModeEnum.getMatchedEnum(shareProfitMode);
                if(isNull(shareProfitModeEnum)){
                    throw new BusinessException(RespCodeEnum.PARAM_ERROR);
                }
                agentInfoDo.setShareProfitMode(ShareProfitModeEnum.ONLINE.equals(shareProfitModeEnum));
            }
        }

        return agentInfoDo;
    }

    private List<AgentInfoVO> buildResults(List<AgentInfoDo> agentInfoDoList) {
        if(isNull(agentInfoDoList)){
            return new ArrayList<>();
        }
        List<AgentInfoVO> agentInfoVOList = new ArrayList<>();

        AgentInfoVO agentInfoVO;

        Integer id;
        String agentId;
        String agentName;
        AgentStatEnum status;
        String shareProfitRate;
        ShareProfitModeEnum shareProfitMode;
        String addTime;
        String linkurl;

        for (AgentInfoDo agentInfoDo : agentInfoDoList) {
            id = agentInfoDo.getId();
            agentId = agentInfoDo.getAgentId();
            agentName = agentInfoDo.getAgentName();
            status = agentInfoDo.getStat() ? AgentStatEnum.OPEN : AgentStatEnum.CLOSE;
            shareProfitRate = agentInfoDo.getShareProfitRate() + "%";
            shareProfitMode = agentInfoDo.getShareProfitMode() ? ShareProfitModeEnum.ONLINE : ShareProfitModeEnum.OFFLINE;
            addTime = buildTime(agentInfoDo.getAddTime());
            linkurl = agentInfoDo.getLinkurl();
            agentInfoVO = new AgentInfoVO(id, agentId, agentName,
                    status, shareProfitRate,
                    shareProfitMode, addTime, linkurl);
            agentInfoVOList.add(agentInfoVO);
        }

        return agentInfoVOList;
    }

    private Map<String, Object> buildConditions(AgentInfoConditionVO condition) {
        Boolean showAll = condition.getShowAll();

        if(isNull(showAll)){
            return new HashMap<>();
        }

        Map<String, Object> conditions = new HashMap<>();

        if(!showAll){
            conditions.put("stat", AgentStatEnum.OPEN.getCode());
        }

        return conditions;
    }
}
