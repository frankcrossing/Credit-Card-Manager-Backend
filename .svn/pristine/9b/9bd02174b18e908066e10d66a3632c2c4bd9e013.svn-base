package com.jieandata.web.controller.plan;

import com.jieandata.biz.plan.PlanManager;
import com.jieandata.service.model.plan.PlanDetailInfoVO;
import com.jieandata.service.model.plan.PlanInfoConditionVO;
import com.jieandata.service.model.plan.PlanInfoVO;
import com.jieandata.utils.bean.response.BaseResponse;
import com.jieandata.utils.common.enums.RespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: pengke
 * @Date: 2019-8-7 17:27
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanManager planManager;

    @RequestMapping(value = "/planInfoList",method = {RequestMethod.POST})
    public BaseResponse<List<PlanInfoVO>> planInfoList(@RequestBody PlanInfoConditionVO condition){
        log.info("in planInfoList, condition:[{}]", condition);

        List<PlanInfoVO> data = planManager.getPlanInfoList(condition);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

    @RequestMapping(value = "/planDetailInfoList",method = {RequestMethod.POST})
    public BaseResponse<List<PlanDetailInfoVO>> planDetailInfoList(@RequestParam String planNo){
        log.info("in planDetailInfoList, planNo:[{}]", planNo);

        List<PlanDetailInfoVO> data = planManager.getPlanDetailInfoList(planNo);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }
}
