package com.jieandata.service.model.chart;

@SuppressWarnings("rawtypes")
public class BarStackSeriesCell<T> extends LineStackSeriesCell{

	private static final long serialVersionUID = -6771113151029240417L;

	private String barWidth;

	public String getBarWidth() {
		return barWidth;
	}

	public void setBarWidth(String barWidth) {
		this.barWidth = barWidth;
	}
}
