package com.jieandata.service.model;

import com.jieandata.service.model.chart.PageBaseData;
import java.io.Serializable;

public class TransStatisticsDataVO implements Serializable {
	private static final long serialVersionUID = -5859963453764360570L;
	private PageBaseData numData;
	private PageBaseData moneyData;
	public PageBaseData getNumData() {
		return numData;
	}
	public void setNumData(PageBaseData numData) {
		this.numData = numData;
	}
	public PageBaseData getMoneyData() {
		return moneyData;
	}
	public void setMoneyData(PageBaseData moneyData) {
		this.moneyData = moneyData;
	}
}
