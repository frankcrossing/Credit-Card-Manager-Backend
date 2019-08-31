package com.jieandata.service.model.chart;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PieLegendData implements Serializable {
	private static final long serialVersionUID = -7672572315965382928L;
	private List<String> legendData;
	private Map<String, Boolean> selected;
	private List<PieLegendSeriesCell> seriesData;

	public List<String> getLegendData() {
		return legendData;
	}
	public void setLegendData(List<String> legendData) {
		this.legendData = legendData;
	}
	public Map<String, Boolean> getSelected() {
		return selected;
	}
	public void setSelected(Map<String, Boolean> selected) {
		this.selected = selected;
	}
	public List<PieLegendSeriesCell> getSeriesData() {
		return seriesData;
	}
	public void setSeriesData(List<PieLegendSeriesCell> seriesData) {
		this.seriesData = seriesData;
	}
}
