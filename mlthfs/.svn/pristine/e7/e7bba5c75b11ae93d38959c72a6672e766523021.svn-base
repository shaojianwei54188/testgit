package com.hhu.mlthfs.model;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author HHU
 * @since 2018-10-14
 */
@TableName("FORECAST_RESULT")
@KeySequence(value = "forecast_result_sq")
public class ForecastResult extends Model<ForecastResult> {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 预报断面
     */
    private String forecastSection;
    /**
     * 起报时间
     */
    private String forecastTimeStart;
    /**
     * 方案编号
     */
    private String planId;
    /**
     * 方案类型（0：单方案，1组合方案）
     */
    private Integer planType;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 预报时间
     */
    private String forecastTime;
    /**
     * 单模型预报结果
     */
    private Double forecastValue;
    /**
     * 历史均值（单）
     */
    private Double historyAverage;
    /**
     * 预报距平
     */
    private Double forecastDeparture;
    /**
     * 预报等级
     */
    private String forecastLevel;
    /**
     * 单模型校正结果
     */
    private Double forecastAdjustValue;
    /**
     * 模型综合（BMA）结果
     */
    private Double forecastBmaValue;
    /**
     * 可靠性评估(q50)
     */
    private Double forecastQ50Value;
    /**
     * 可靠性评估（q5)
     */
    private Double forecastQ5Value;
    /**
     * 可靠性评估（q95）
     */
    private Double forecastQ95Value;
    private Integer createBy;
    private Date createDate;
    private Integer updateBy;
    private Date updateDate;
    private Integer delFlag;
    private String remarks;


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

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    public String getForecastLevel() {
        return forecastLevel;
    }

    public void setForecastLevel(String forecastLevel) {
        this.forecastLevel = forecastLevel;
    }

    public Double getForecastAdjustValue() {
        return forecastAdjustValue;
    }

    public void setForecastAdjustValue(Double forecastAdjustValue) {
        this.forecastAdjustValue = forecastAdjustValue;
    }

    public Double getForecastBmaValue() {
        return forecastBmaValue;
    }

    public void setForecastBmaValue(Double forecastBmaValue) {
        this.forecastBmaValue = forecastBmaValue;
    }

    public Double getForecastQ50Value() {
        return forecastQ50Value;
    }

    public void setForecastQ50Value(Double forecastQ50Value) {
        this.forecastQ50Value = forecastQ50Value;
    }

    public Double getForecastQ5Value() {
        return forecastQ5Value;
    }

    public void setForecastQ5Value(Double forecastQ5Value) {
        this.forecastQ5Value = forecastQ5Value;
    }

    public Double getForecastQ95Value() {
        return forecastQ95Value;
    }

    public void setForecastQ95Value(Double forecastQ95Value) {
        this.forecastQ95Value = forecastQ95Value;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ForecastResult{" +
                ", id=" + id +
                ", forecastSection=" + forecastSection +
                ", forecastTimeStart=" + forecastTimeStart +
                ", planId=" + planId +
                ", planType=" + planType +
                ", modelName=" + modelName +
                ", forecastTime=" + forecastTime +
                ", forecastValue=" + forecastValue +
                ", historyAverage=" + historyAverage +
                ", forecastDeparture=" + forecastDeparture +
                ", forecastLevel=" + forecastLevel +
                ", forecastAdjustValue=" + forecastAdjustValue +
                ", forecastBmaValue=" + forecastBmaValue +
                ", forecastQ50Value=" + forecastQ50Value +
                ", forecastQ5Value=" + forecastQ5Value +
                ", forecastQ95Value=" + forecastQ95Value +
                ", createBy=" + createBy +
                ", createDate=" + createDate +
                ", updateBy=" + updateBy +
                ", updateDate=" + updateDate +
                ", delFlag=" + delFlag +
                ", remarks=" + remarks +
                "}";
    }
}
