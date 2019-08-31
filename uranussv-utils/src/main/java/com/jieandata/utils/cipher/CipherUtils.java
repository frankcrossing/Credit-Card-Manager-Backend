package com.jieandata.utils.cipher;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Auther: pengke
 * @Date: 2019-1-10 14:56
 * @Description:加解密工具(施攀算法)
 */
@Slf4j
public class CipherUtils {
    /**
     * 密匙
     */
    private static String CIPHER_KEY = "eisl8dikehkJuHeXinYongCont0islde9ff";

    public static String spanDecode(String cipher){
        if(StringUtils.isBlank(cipher)){
            return StringUtils.EMPTY;
        }
        return encrypt(cipher, 'D');
    }

    public static String spanEncrypt(String plaintext){
        if(StringUtils.isBlank(plaintext)){
            return StringUtils.EMPTY;
        }
        return encrypt(plaintext, 'E');
    }

    /**
     *
     * @param string 需要加密解密的字符串
     * @param operation 判断是加密还是解密，E表示加密，D表示解密
     * @return 对称加密解密
     */
    public static String encrypt(String string, char operation){
        String key = DigestUtils.md5Hex(CIPHER_KEY);
        int key_length = StringUtils.length(key);
        byte[] strBytes = Base64.getMimeDecoder().decode(string);
        int string_length = strBytes.length;
        int[] rndkey = new int[256];
        int[] box = new int[256];

        for(int i = 0; i < 256; i++){
            rndkey[i] = (int)(key.charAt(i%key_length));
            box[i] = i;
        }
        for(int j = 0, i = 0; i < 256; i++){
            j = (j + box[i] + rndkey[i]) % 256;
            int tmp = box[i];
            box[i] = box[j];
            box[j] = tmp;
        }

        byte[] last = new byte[string_length];

        for(int a = 0, j = 0, i = 0, k = 0; i < string_length; i++, k++){
            a = (a+1) % 256;
            j = (j + box[a]) % 256;
            int tmp = box[a];
            box[a] = box[j];
            box[j] = tmp;
            int b = (int)strBytes[i];

            int boxVal = box[(box[a]+box[j])%256];
            last[k] = (byte)(b ^ boxVal);
        }

        String result = new String(last, StandardCharsets.UTF_8);

        if(operation == 'D'){
            if(StringUtils.substring(result,0,8).equals(StringUtils.substring(DigestUtils.md5Hex(StringUtils.substring(result,8) + key),0,8))){
                return StringUtils.substring(result,8);
            }else{
                return "";
            }
        }else{
            byte[] encodeBytes = Base64.getMimeEncoder().encode(last);
            String encodeStr = new String(encodeBytes, StandardCharsets.UTF_8);//StringUtils.toEncodedString(encodeBytes, StandardCharsets.UTF_8);
            return StringUtils.replace(encodeStr,"=","");
        }
    }

    public static void main(String[] args) {
        System.out.println(encrypt("BSbccnqW7hDHlpDZDXn5+pM",'D'));
    }
}
