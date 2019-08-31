package com.jieandata.utils.base;

import com.jieandata.jaguar.common.utils.convert.DateUtils;
import com.jieandata.utils.cipher.CipherUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-8-16 10:12
 * @Description:
 */
public class BaseUtils {
    protected static boolean isNull(Object object) {
        if (object == null){
            return true;
        }
        boolean isNull = true;
        if (object instanceof String) {
            String t = (String) object;
            if (!t.trim().equals("") && !t.equals("undefined") && !t.equals("null")){
                isNull = false;
            }
        } else if (object instanceof List) {
            List t = (List) object;
            if (!t.isEmpty()){
                isNull = false;
            }
        } else if (object instanceof Map) {
            Map t = (Map) object;
            if (!t.isEmpty()){
                isNull = false;
            }
        } else {
            isNull = false;
        }
        return isNull;
    }

    protected static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    protected static boolean isAnyNull(Object ...objects) {
        if(isNull(objects)){
            return true;
        }
        for(Object o : objects){
            if(isNull(o)){
                return true;
            }
        }
        return false;
    }

    protected static boolean isAllNull(Object ...objects) {
        if(isNull(objects)){
            return true;
        }
        for(Object o : objects){
            if(isNotNull(o)){
                return false;
            }
        }
        return true;
    }

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
