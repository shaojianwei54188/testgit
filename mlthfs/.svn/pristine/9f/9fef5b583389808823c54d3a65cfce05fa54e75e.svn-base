package com.hhu.mlthfs.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author HHU
 * @since 2018-10-13
 */
@TableName("train_result")
@KeySequence(value = "train_result_sq")
public class TrainResult extends Model<TrainResult> {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 方案编号
     */
    private String planId;
    /**
     * 预报断面
     */
    private String forecastSection;
    /**
     * 起报时间
     */
    private String forecastTimeStart;
    /**
     * 预报时间
     */
    private String forecastTime;
    /**
     * 年份
     */
    private String yearNo;
    /**
     * 实测值
     */
    private Double measuredValue;
    /**
     * 率定值
     */
    private Double trainResultValue;
    /**
     * 模型名称
     */
    private String modelName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
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

    public String getYearNo() {
        return yearNo;
    }

    public void setYearNo(String yearNo) {
        this.yearNo = yearNo;
    }

    public Double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public Double getTrainResultValue() {
        return trainResultValue;
    }

    public void setTrainResultValue(Double trainResultValue) {
        this.trainResultValue = trainResultValue;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TrainResult{" +
                ", id=" + id +
                ", planId=" + planId +
                ", forecastSection=" + forecastSection +
                ", forecastTimeStart=" + forecastTimeStart +
                ", forecastTime=" + forecastTime +
                ", yearNo=" + yearNo +
                ", measuredValue=" + measuredValue +
                ", trainResultValue=" + trainResultValue +
                ", modelName=" + modelName +
                "}";
    }
}
