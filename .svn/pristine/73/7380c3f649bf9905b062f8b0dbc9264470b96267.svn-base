package com.jieandata.test.utils;

import com.jieandata.jaguar.common.utils.cipher.rsa.RsaSignature;

/**
 * @author master.yang
 * @version $$Id: com.jieandata.test.utils.TestGenerateSign, v 0.1 2018/7/6 下午5:05 master.yang Exp $$
 */
public class TestGenerateSign {

    public static void main(String[] args) {
        String apiKey = "935f2e08-a96f-4050-adfd-280e1d315247";
        String market =  "02";
        String secretKey = "54149BC3DDB58114350DEC911738163F";

        String userId = "40998";

        String toSign = apiKey + market + secretKey + userId;

        String privateKey = "MIICXAIBAAKBgQChvfDV0cQTfnwG/7qZ7ZWCzr8QN5yb0jSQuTFoYbtXBvaZytK3RlDz9CLceGH1xFbIlrMF6zu35aCcm7xnyf8lnSsQOhLIjJE10pK5el6dnINm3YzNgZj3pKI91q/tnceeSyjQt3n63zsQi4XpXy/Spj+K4H3HKxX7P4tn4n0IQIDAQABAoGBAIRzzJb9eknQifcdUw2dH5QIhTTdpdWBNeTSk+B8MHObUzUsgJTv83lkE2xi9S3ThJItvxt4wOXfGUFG0+pW5Cb3GPOIFuylkNFeAbHlhMnkYqVt2IWD+7yPL25sgUuuOmGtHGn6jG1ACKmnQfSC/vJEqBjJKaTO4QQ20G9ol1jxAkEAzj1a+6j5qxQugrtPQN0r9G/cFyM07xB3Y0FNR6PFc1BA+K/B8+A2vmSTKrOEEEUg+QzkQ1SomLM4z+swbHjFNQJBAMjEIT2ei9iQ+hhY5EcgHE+uaO4A6FQsj9RpzxaQXZKlpyKlzFdSe/SOlT3U0OklyrDXFUnSOCWHRDccQsY2bL0CQBOxhCiXwA94A+Dz5eN5uyLCM6/56qoRVnUh3TFEECyssyeMEOcqt8+CZxMixS+Qik99zaYoRVkfdANWn+8bsSkCQGaaPXa1UTkDlpzcyQVEdtOOCdggpJtoDrV6wbgBXaD1gb4mR5EU+X5ZZBIucfnFM5o+wYVxpvoe8BDOI54S8G0CQDHFvdmlFtkGH09p0r6bAPQ8ZCXDhywDhoyJJOd/m4yDKysczZeWvhLA8Co0CXOhXojEC/yqX+BWeC1Sxc9sgoQ=";

        String sign = RsaSignature.sign(toSign, privateKey);

        System.out.println(sign);
    }
}
