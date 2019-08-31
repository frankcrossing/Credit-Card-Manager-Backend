package com.jieandata.service.model.chart;

import java.io.Serializable;

public class PageBaseData implements Serializable {
	private static final long serialVersionUID = -4590330254407320434L;
	private LineStackData lineStackData;
	private BarStackData barStackData;
	private PieLegendData pieLegendData;
	public LineStackData getLineStackData() {
		return lineStackData;
	}
	public void setLineStackData(LineStackData lineStackData) {
		this.lineStackData = lineStackData;
	}
	public BarStackData getBarStackData() {
		return barStackData;
	}
	public void setBarStackData(BarStackData barStackData) {
		this.barStackData = barStackData;
	}
	public PieLegendData getPieLegendData() {
		return pieLegendData;
	}
	public void setPieLegendData(PieLegendData pieLegendData) {
		this.pieLegendData = pieLegendData;
	}
}
