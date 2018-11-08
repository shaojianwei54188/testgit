package com.hhu.mlthfs.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author HHU
 * @since 2018-10-24
 */
@TableName("FORECAST_DATA_RESULT")
public class ForecastDataResult extends Model<ForecastDataResult> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String forecastSection;
	private String forecastTimeStart;
	private String forecastTime;
	private String planName;
	private Double forecastValue;
	private Double historyAverage;
	private Double forecastDeparture;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForecastSection() {
		return forecastSection;
	}

	public void setForecastSection(String forecastSection) {
		this.forecastSection = forecastSection;
	}

	public String getForecastTimeStart() {
		return forecastTimeStart;
	}

	public void setForecastTimeStart(String forecastTimeStart) {
		this.forecastTimeStart = forecastTimeStart;
	}

	public String getForecastTime() {
		return forecastTime;
	}

	public void setForecastTime(String forecastTime) {
		this.forecastTime = forecastTime;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Double getForecastValue() {
		return forecastValue;
	}

	public void setForecastValue(Double forecastValue) {
		this.forecastValue = forecastValue;
	}

	public Double getHistoryAverage() {
		return historyAverage;
	}

	public void setHistoryAverage(Double historyAverage) {
		this.historyAverage = historyAverage;
	}

	public Double getForecastDeparture() {
		return forecastDeparture;
	}

	public void setForecastDeparture(Double forecastDeparture) {
		this.forecastDeparture = forecastDeparture;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ForecastDataResult{" +
			", id=" + id +
			", forecastSection=" + forecastSection +
			", forecastTimeStart=" + forecastTimeStart +
			", forecastTime=" + forecastTime +
			", planName=" + planName +
			", forecastValue=" + forecastValue +
			", historyAverage=" + historyAverage +
			", forecastDeparture=" + forecastDeparture +
			"}";
	}
}
