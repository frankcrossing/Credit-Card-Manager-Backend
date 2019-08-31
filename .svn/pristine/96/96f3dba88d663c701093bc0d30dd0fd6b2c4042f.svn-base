package com.jieandata.utils.bean;

import com.jieandata.utils.constant.Constants;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

@Slf4j
public abstract class CommonUtils {

    public static String setEmptyIfNull(String value) {
        if (StringUtils.isBlank(value)) {
            return StringUtils.EMPTY;
        }
        if (Constants.NULL_VALUE.equalsIgnoreCase(value)) {
            return StringUtils.EMPTY;
        }
        return value;
    }

    /**
     * 全角转半角
     *
     * @param QJstr
     * @return String
     */
    public static String QJToBJ(String QJstr) {
        String outStr = "";
        byte[] b = null;
        try {
            b = QJstr.getBytes("unicode");
        } catch (UnsupportedEncodingException e) {
            log.error("全角转半角转换原始字符串发生异常",e);
        }

        int pos = 0;

        for (int i = 0; i < QJstr.length(); i++) {
            pos += 2;
            if (b[pos] == -1) {
                b[pos + 1] = (byte) (b[pos + 1] + 32);
                b[pos] = 0;
            }
        }

        try {
            outStr = new String(b, "unicode");
        } catch (UnsupportedEncodingException e) {
            log.error("全角转半角转换原始字符串发生异常",e);
        }

        return outStr;
    }

    /*
     * unicode编码转中文
     */
    public static String decodeUnicode(final String dataStr) {
        try{
            final StringBuffer buffer = new StringBuffer(dataStr==null?"":dataStr);
            if(StringUtils.isNotBlank(dataStr) && dataStr.contains("\\u")) {
                buffer.delete(0,buffer.length());
                int start = 0;
                int end = 0;
                while (start > -1) {
                    end = dataStr.indexOf("\\u", start + 2);
                    String a="";//如果夹着非unicode编码的字符串，存放在这
                    String charStr = "";
                    if (end == -1) {
                        if(dataStr.substring(start + 2, dataStr.length()).length()>4){
                            charStr = dataStr.substring(start + 2, start + 6);
                            a = dataStr.substring(start + 6, dataStr.length())  ;
                        }else{
                            charStr = dataStr.substring(start + 2, dataStr.length());
                        }
                    } else {
                        charStr = dataStr.substring(start + 2, end);
                    }
                    char letter = (char) Integer.parseInt(charStr.trim(), 16); // 16进制parse整形字符串。
                    buffer.append(new Character(letter).toString());
                    if(StringUtils.isNotBlank(a)){
                        buffer.append(a);
                    }
                    start = end;
                }
            }
            return buffer.toString();
        } catch (Exception e){
            log.error(dataStr+" 字符串转换失败",e);
        }
        return dataStr;
    }
}
