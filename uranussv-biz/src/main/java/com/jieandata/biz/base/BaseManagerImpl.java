package com.jieandata.biz.base;

import com.jieandata.jaguar.common.utils.convert.DateUtils;
import com.jieandata.utils.base.BaseUtils;
import com.jieandata.utils.cipher.CipherUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class BaseManagerImpl extends BaseUtils {
    /**
     * 10位时间转(yyyy-MM-dd HH:mm:ss)
     * @param addTime
     * @return
     */
    protected static String buildTime(Integer addTime){
        String timeStr = StringUtils.EMPTY;
        if(addTime != null){
            long longTime = 1000L * addTime;
            timeStr = DateUtils.toLongDateString(new Date(longTime));
        }
        return timeStr;
    }

    /**
     * 生成银行卡号
     * @param cardBin
     * @param bankFlag
     * @return
     */
    protected static String buildCardNum(String cardBin, String bankFlag){
        String timeStr = StringUtils.EMPTY;
        if(!isAnyNull(cardBin, bankFlag)){
            timeStr = cardBin + " **** **** " + CipherUtils.spanDecode(bankFlag);
        }
        return timeStr;
    }
}
