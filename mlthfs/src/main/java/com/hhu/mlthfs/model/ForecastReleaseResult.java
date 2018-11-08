package com.hhu.mlthfs.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author HHU
 * @since 2018-10-31
 */
@TableName("FORECAST_RELEASE_RESULT")
@KeySequence(value = "forecast_release_result_sq" ,clazz = Long.class)
public class ForecastReleaseResult extends Model<ForecastReleaseResult> {

    private static final long serialVersionUID = 1L;
	@TableId(value = "ID", type = IdType.INPUT)
	private Long id;
    /**
     * 预报断面
     */
	private String forecastSection;
    /**
     * 预报时间
     */
	private String forecastTime;
    /**
     * 预报值
     */
	private Double forecastValue;
    /**
     * 发布时间
     */
	private Date releaseTime;
    /**
     * 发布方式（0：自动，1：手动）
     */
	private Integer releaseType;
	private Integer delFlag;
    /**
     * 发布人（系统或者优选预报值的人的姓名）
     */
	private String releasePerson;
    /**
     * 模型名称
     */
	private String modelName;
    /**
     * 起报时间
     */
	private String forecastTimeStart;


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

	public String getForecastTime() {
		return forecastTime;
	}

	public void setForecastTime(String forecastTime) {
		this.forecastTime = forecastTime;
	}

	public Double getForecastValue() {
		return forecastValue;
	}

	public void setForecastValue(Double forecastValue) {
		this.forecastValue = forecastValue;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(Integer releaseType) {
		this.releaseType = releaseType;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getReleasePerson() {
		return releasePerson;
	}

	public void setReleasePerson(String releasePerson) {
		this.releasePerson = releasePerson;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getForecastTimeStart() {
		return forecastTimeStart;
	}

	public void setForecastTimeStart(String forecastTimeStart) {
		this.forecastTimeStart = forecastTimeStart;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ForecastReleaseResult{" +
			", id=" + id +
			", forecastSection=" + forecastSection +
			", forecastTime=" + forecastTime +
			", forecastValue=" + forecastValue +
			", releaseTime=" + releaseTime +
			", releaseType=" + releaseType +
			", delFlag=" + delFlag +
			", releasePerson=" + releasePerson +
			", modelName=" + modelName +
			", forecastTimeStart=" + forecastTimeStart +
			"}";
	}
}
