package com.jieandata.test.utils;

import com.jieandata.jaguar.common.utils.cipher.rsa.RsaUtils;

import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author master.yang
 * @version $$Id: TestRsaDecrypt, v 0.1 2018/7/6 下午6:23 master.yang Exp $$
 */
public class TestRsaDecrypt {

    public static void main(String[] args) throws Exception {
        String chipher = "bP2HUW3kkTNXZU4dgT93LsPacnJOrb4no_y5OLWzBTxZ9tZOyMdFUwohzfgq8HLK9ax_6Qx3WZmsz3ITqePHXThBuBU7L0XWmRbGAZvx5lsALYPFc7kSosC2k1X0O8o_wYuouBWwp7FeZyPjGZ931jZNmFG6VtehBkCRVNy1cr8";

        System.out.println(chipher);

        chipher = chipher.replace("-", "+");
        chipher = chipher.replace("_", "/");
        chipher = chipher.replace("\"", "=");

        System.out.println(chipher);

        String privateKey = "MIICXAIBAAKBgQChvfDV0cQTfnwG/7qZ7ZWCzr8QN5yb0jSQuTFoYbtXBvaZytK3RlDz9CLceGH1xFbIlrMF6zu35aCcm7xnyf8lnSsQOhLIjJE10pK5el6dnINm3YzNgZj3pKI91q/tnceeSy/jQt3n63zsQi4XpXy/Spj+K4H3HKxX7P4tn4n0IQIDAQAB" +
                "AoGBAIRzzJb9eknQifcdUw2dH5QIhTTdpdWBNeTSk+B8MHObUzUsgJTv83lkE2xi9S3ThJItvxt4wOXfGUFG0+pW5Cb3GPOIFuylkNFeAbHlhMnkYqVt2IWD+7yPL25sgUuuOmGtHGn6jG1ACKmnQfSC/vJEqBjJKaTO4QQ20G9ol1jxAkEAzj1a+6j5qxQugrtPQN0r9G/cFyM07xB3Y0FNR6PFc1BA+K/B8+A2vmSTKrOEEEUg+QzkQ1SomLM4z+swbHjFNQJBAMjEIT2ei9iQ+hhY5EcgHE+uaO4A6FQsj9RpzxaQXZKlpyKlzFdSe/SOlT3U0OklyrDXFUnSOCWHRDccQsY2bL0CQBOxhCiXwA94A+Dz5eN5uyLCM6/5" +
                "6qoRVnUh3TFEECyssyeMEOcqt8+CZxMixS+Qik99zaYoRVkfdANWn+8bsSkCQGaa" +
                "PXa1UTkDlpzcyQVEdtOOCdggpJtoDrV6wbgBXaD1gb4mR5EU+X5ZZBIucfnFM5o+wYVxpvoe8BDOI54S8G0CQDHFvdmlFtkGH09p0r6bAPQ8ZCXDhywDhoyJJOd/m4yDKysczZeWvhLA8Co0CXOhXojEC/yqX+BWeC1Sxc9sgoQ=";

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChvfDV0cQTfnwG/7qZ7ZWCzr8QN5yb0jSQuTFoYbtXBvaZytK3RlDz9CLceGH1xFbIlrMF6zu35aCcm7xnyf8lnSsQOhLIjJE10pK5el6dnINm3YzNgZj3pKI91q/tnceeSy/jQt3n63zsQi4XpXy/Spj+K4H3HKxX7P4tn4n0IQIDAQAB";

       // RSAPublicKey rsaPublicKey = RsaUtils.loadPublicKeyByStr(publicKey);

        String privateKeyStr = RsaUtils.loadPrivateKeyByFile("/Users/yangyebo/Downloads/rsa_private_dbd_key.pem");

        RSAPrivateKey rsaPrivateKey = RsaUtils.loadPrivateKeyByStr(privateKeyStr);

        byte[] plaintext = RsaUtils.decrypt(RsaUtils.loadPrivateKeyByStr(privateKey), chipher.getBytes());

        System.out.println(new String(plaintext));
    }
}
