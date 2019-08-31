package com.jieandata.service.model.chart;

import java.io.Serializable;

public class PieLegendSeriesCell<T> implements Serializable {
	private static final long serialVersionUID = 6002972125381242441L;
	private String name;
	private T value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
