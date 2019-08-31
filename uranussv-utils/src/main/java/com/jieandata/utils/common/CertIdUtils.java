package com.jieandata.utils.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: pengke
 * @Date: 2019-7-25 16:45
 * @Description: 身份证信息解析工具
 */
public class CertIdUtils {

    public static final String SEX_MAN = "男";

    public static final String SEX_WOMEN = "女";

    /**
     * 获取城市
     * @param certId
     * @return
     */
    public static String getCity(String certId){
        if(StringUtils.isBlank(certId) || certId.length() < 2){
            return StringUtils.EMPTY;
        }
        String provinceid = StringUtils.substring(certId, 0, 2);
        for (int i = 0; i < IdcardValidator.cityCode.length; i++) {
            if (IdcardValidator.cityCode[i].equals(provinceid)) {
                return IdcardValidator.codeAndCity[i][1];
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取性别
     * @param certId
     * @return
     */
    public static String getSex(String certId){
        if(StringUtils.isBlank(certId) || certId.length() < 15){
            return StringUtils.EMPTY;
        }
        String idcard = certId;
        if (idcard.length() == 15) {
            idcard = IdcardValidator.convertIdcarBy15bit(idcard);
        }
        String sexid = StringUtils.substring(idcard, 16, 17);
        if(StringUtils.isBlank(sexid)){
            return StringUtils.EMPTY;
        }
        return Integer.valueOf(sexid) % 2 == 0 ? SEX_WOMEN : SEX_MAN;
    }

}
