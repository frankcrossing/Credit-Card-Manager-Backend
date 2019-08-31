/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.17 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('1','risksv.baidu.map.ak','aiqH7r5uK194Mz92tyUWbGTttXlGGi7C','0','0','百度地图ak');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('2','risksv.moxie.appid','ccfbc0ce28de4a549329c07389fc1eb6','0','0','魔蝎魔杖AppID');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('3','risksv.moxie.report.validday','30','0','0','魔蝎报告有效天数，小于0则不更新');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('4','risksv.moxie.carrier.validday','30','0','0','魔蝎运营商报告有效天数，小于0则不更新');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('5','risksv.moxie.privatekey','MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQb/6Wu0FfDKAkBHWFpYXSngmv9oSDTlkI4VOEBEdMJmkuyIw/Q/knEw+2hHBusOYzOGCzvqIFqBo8oIEwzSmCEnZyozUvuJsflUShSE/CvqRAMvmz9nmlzyKPvT8ass9nA857nx/trQmDMdh3I1DecMENwT9122yQcdlNON7R01wAcTCI3qLj5UgxfuKxDyD2fKdCpqqgoPqDiZq4fqFn+5IOyk0p8Srt8TQ3HQKlkktvu2Aio0vBVCdEsbNnvcR6kMNcUzFbtwpTpPCVE7elgONLbPvpb6bcz8ihyw5nJKWlLdVg71ZlwpHQXDQhSsvJav0XptA91GDlp/RIQpwjAgMBAAECggEBALufFBu6Eu3r/3psSR00EXG0sCOkU0OekqZbrUF4WHVDXgqumw+Xr/5sOgigzlPVCGGyrdkeD9nnpzZLg/7ZrjNXSyeFoaqDEZ8sTcqfvKwfztm7COnlQzrtaL7aKqNtsSOZWZQNeEAJMjbV93PGZlTUSfKHsQf1q5OZ53CLcIaNiqMXnrembzVd0nbMBWmpfZpiLl4A5pYc+LUy9KvrQDXw5ARZTsZV0EYTEo9VBL6Erv5XOkxw0r1r3YygGCCTQofM/f9LcpE8VucV3Z8C52cDro5KDxsY7OQpfHC3BdnMD+cjPayvlql6IJjpBr7Z+ROf86vtxwPb6DH2XZ1ArQECgYEA62QMOAYOc/dpQEE6MPeGNhYGhAF90+HtwSw2FvU64y2C0G2EayrrCi2upI7ZMo0SnZF5AbF/5nqaHwyWMhWyYuQIn7UOSWl76dnwiIUA3EllwnigNgQkUxG0PlxJsME2u4c8tjm5Yavmhv2/rFOdSgi26T4jD8zOnr7N9y3BrDkCgYEA4q/Tbleae1GFyX+D9tsBoVSN/BfrXt91BFqthtKcFC50ekylRTe7HIiPYtzK+0SMQeL0JlL0vXbHzTvMMR9PEKaA5J/MgDo85ZTMM56eHKdBA7ju8ghkfzOlboX+Yuvo34yay6AbEiBW5S0/1rb4UkVZ2ispaAvGuvChZwr1QzsCgYEAkMSdRy9iYCv/jUcQdOEmp8jwBOut6UwAH1gDhCcaKnHpDCruz8I7f60MxaQdLJvaoRHA7CuwT52DgCkLjo4NgghgzWha+wdm8DHbXvr9xn1Vmj75uX7eoEA5LEkyAQUzli3cRu5Fdy5zvv38jg12pPurEtPmWGdLhBIxNh3sCPECgYAqjvgS7z+Bh3ymp9oOrm9P6p/9hEAcP7eoaZ3Kgh/rag1UKK+enyfx43GIDgvNwMDUXdeYmlp4d6RrU56yWj5t0dTBF389U7G7KIRt7Imit4PtPvsdVZYIi5mzdlScHc5Kqgslz5lFfezSefxSQ2e7immkHBZaAlv9HNAwmE4ToQKBgAJDOtPk92zLVCkEJPiWGvY1cUDxtoqs4jp75xh2b+Ix8QnUB3ku1AYaq1MGc2CtY/hvxiE4B+t81qixvxQ7e04CiU4Q/LlV/sNrMzS71+K8JfqrsB0YOpi1EzdA0OwAqEy3QnbDDWQNxLa9ddZkeWjiSBdMLr0CsuNsl3MUp6kK','0','0','魔蝎魔杖私钥');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('6','system.check.type','MR','0','0','审核类型 MR机审 MP人审 MRP机审+人审');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('7','system.bdapi.config','{\"requestInfo\":\"http:\\/\\/api.map.baidu.com\\/geocoder\\/v2\\/?callback=renderReverse\",\"method\":\"GET\",\"requestParam\":{\"location\":\"\",\"output\":\"json\",\"pois\":\"1\",\"ak\":\"aiqH7r5uK194Mz92tyUWbGTttXlGGi7C\"}}','0','0','百度地图api配置 requestInfo请求地址 method请求类型 location经纬度 output返回数据格式 ak(apikey)');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('8','system.moxie.config','{\"operaAuth\":{\"apiKey\":\"8a0912335f70435dadc4e3956547fb2f\",\"token\":\"ccfbc0ce28de4a549329c07389fc1eb6\",\"requestUrl\":\"https:\\/\\/api.51datakey.com\\/carrier\\/v3\\/mobiles\\/{mobile}\\/mxdata-ex\",\"userReport\":\"https:\\/\\/api.51datakey.com\\/carrier\\/v3\\/mobiles\\/{mobile}\\/mxreport?name={name}&idcard={idcard}\"},\"userLiving\":{\"appId\":\"ccfbc0ce28de4a549329c07389fc1eb6\",\"version\":\"1.0\",\"method\":{\"CPOCR\":\"moxie.api.risk.orc.idcard.front\",\"COOCR\":\"moxie.api.risk.orc.idcard.back\",\"LIV\":\"moxie.api.risk.static-face-liveness\",\"AUH\":\"moxie.api.risk.self-idcard.verification\"},\"sign_type\":\"TOKEN\",\"fileType\":{\"CP\":\"1\",\"CO\":\"2\",\"LPA1\":\"3\",\"LPA2\":\"3\",\"LPA3\":\"3\",\"LPA4\":\"3\",\"VID\":\"4\"},\"uploadFileUrl\":\"https:\\/\\/res.51datakey.com\\/resource\\/api\\/v1\\/upload\\/file\",\"authUrl\":\"https:\\/\\/api.51datakey.com\\/identity\\/api\\/gateway\"}}','0','0','魔蝎运营商配置 requestUrl运营商原始数据接口地址 userReport用户资信报告接口地址 appId(key) CPOCR身份证正面ocr COOCR身份证反面ocr LIV活体 AUH人证 uploadFileUrl上传文件接口 authUrl认证类接口地址');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('9','system.cjpay.config','{\"common\":{\"Version\":\"1.0\",\"PartnerId\":\"200002180487\",\"InputCharset\":\"UTF-8\",\"SignType\":\"RSA\",\"requestUrl\":\"https:\\/\\/pay.chanpay.com\\/mag-unify\\/gateway\\/receiveOrder.do\",\"rsa_public_key\":\"rsa_public_key.pem\",\"rsa_private_key\":\"rsa_private_key.pem\"},\"bankAuth\":{\"Service\":\"nmg_biz_api_auth_req\",\"Memo\":\"银行卡鉴权\",\"ExpiredTime\":\"10m\",\"NotifyUrl\":\"\",\"BkAcctTp\":\"01\",\"IDTp\":\"01\",\"SmsFlag\":\"1\"},\"bankAuthConfirm\":{\"Service\":\"nmg_api_auth_sms\"},\"bankAuthClean\":{\"Service\":\"nmg_api_auth_unbind\",\"UnbindType\":\"0\"},\"pay\":{\"Service\":\"cjt_dsf\",\"TransCode\":\"T10000\",\"BusinessType\":\"1\",\"CorpPushUrl\":\"http:\\/\\/loan.juhexinyong.cn\\/api\\/callback\\/cjpayOut\\/\",\"AccountType\":\"00\",\"Currency\":\"CNY\",\"LiceneceType\":\"01\"},\"whd\":{\"Service\":\"nmg_biz_api_quick_payment\",\"OrdrName\":\"账户充值\",\"ExpiredTime\":\"10m\",\"TradeType\":\"11\",\"SmsFlag\":\"0\",\"NotifyUrl\":\"http:\\/\\/loan.juhexinyong.cn\\/api\\/callback\\/cjpayIn\\/\"},\"gord\":{\"Service\":\"nmg_api_query_trade\"}}','0','0','畅捷支付配置 common公共请求参数[Version接口版本 PartnerId商户号 InputCharset编码 SignType加密方式 requestUrl接口请求地址 rsa_public_key商户公钥地址 rsa_private_key商户私钥地址] bankAuth银行卡鉴权[Service接口名称 Memo说明 ExpiredTime订单有效期 默认10分钟 NotifyUrl异步通知地址 BkAcctTp卡类型（00 –银行贷记卡;01 –银行借记卡;）IDTp证件类型 01身份证 SmsFlag短信发送标识 0不发送短信 1发送短信] bankAuthConfirm银行卡鉴权确认[Service接口名称] bankAuthClean鉴权解绑银行卡[Service接口名称 UnbindType解绑模式，0为物理删除 1为逻辑删除] pay代付[Service接口名称 TransCode交易码 BusinessType业务类型 0私人 1公司 CorpPushUrl回调通知地址 AccountType账户类型 00借记卡 01贷记卡 Currency货币类型 LiceneceType开户证件类型 01身份证] whd代扣[Service接口名称 OrdrName商品名称 ExpiredTime订单有效期 TradeType交易类型 11即时 12担保 SmsFlag短信发送标识,0：不发送短信 1：发送短信 NotifyUrl回调通知地址] gord代扣订单查询[Service接口名称]');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('10','system.wdsendmsg.config','{\"code\":{\"requestUrl\":\"https:\\/\\/client.movek.net:8443\\/sendvarsms.aspx\",\"method\":\"POST\",\"params\":{\"action\":\"var\",\"userid\":\"3857\",\"account\":\"SDK-A3857-3857\",\"password\":\"526935\",\"msg\":\"\",\"params\":\"\",\"json\":1}},\"notice\":{\"requestUrl\":\"https:\\/\\/client.movek.net:8443\\/sendvarsms.aspx\",\"method\":\"POST\",\"params\":{\"action\":\"var\",\"userid\":\"3940\",\"account\":\"WEB-A3940-3940\",\"password\":\"456321\",\"msg\":\"\",\"params\":\"\",\"json\":1}}}','0','0','短信配置 code验证类[requestUrl请求地址 method请求类型 action发送类型动态参数 userid特服号 account序列号 password密码 msg短信内容 params参数 json返回数据格式1json] notice通知类');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('11','system.jgpushmsg.config','{\"apiKey\":\"dfb52a787989c00a3d48f8b9\",\"apiSecert\":\"c66a99b477baa994b2991d62\"}','0','0','极光推送配置');
insert into `risk_config` (`id`, `configKey`, `configValue`, `addTime`, `updateTime`, `remark`) values('12','risksv.model.carrier.intercept','-2.6586','0','0','风控运营商模型：截距项');
