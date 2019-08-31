package com.jieandata.utils.common.enums;
/**
 * 微信事件
 * create by peng.ke in 2018年9月5日 上午11:39:25
 *
 */
public enum EventEnum {
	CUST_SERVICE_INFO("CUST_SERVICE_INFO","客服信息"),
	QUERY_BALANCE("QUERY_BALANCE","余额"),
	QUERY_RECHARGE_INFO("QUERY_RECHARGE_INFO","充值"),
	TEST_TEXT("TEST_TEXT","文本");
	private String key;
	private String keyWord;
	EventEnum(String key,String keyWord){
		this.setKey(key);
		this.setKeyWord(keyWord);
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public static EventEnum getMatchedEvent(String key) {
		for (EventEnum eventEnum : EventEnum.values()) {
			if (eventEnum.key.equals(key)) {
				return eventEnum;
			}
		}
		return null;
	}
	
	public static EventEnum getMatchedEventByWord(String keyWord) {
		for (EventEnum eventEnum : EventEnum.values()) {
			if (eventEnum.keyWord.equals(keyWord)) {
				return eventEnum;
			}
		}
		return null;
	}
}
