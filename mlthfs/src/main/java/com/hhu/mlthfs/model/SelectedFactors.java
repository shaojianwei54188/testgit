package com.hhu.mlthfs.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableName;
import io.lettuce.core.dynamic.annotation.Key;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author HHU
 * @since 2018-10-13
 */
@TableName("SELECTED_FACTORS")
@KeySequence(value = "selected_factors_sq")
public class SelectedFactors extends Model<SelectedFactors> {

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
     * 预报时间
     */
    private String forecastTime;
    /**
     * 因子年份
     */
    private String yearNo;
    /**
     * 因子月份
     */
    private String monthNo;
    /**
     * 因子编号
     */
    private String climateIndexNo;
    /**
     * 因子名称
     */
    private String climateIndexName;
    /**
     * 因子值
     */
    private String climateIndexValue;
    /**
     * 相关系数
     */
    private Double ccIndex;


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

    public String getYearNo() {
        return yearNo;
    }

    public void setYearNo(String yearNo) {
        this.yearNo = yearNo;
    }

    public String getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(String monthNo) {
        this.monthNo = monthNo;
    }

    public String getClimateIndexNo() {
        return climateIndexNo;
    }

    public void setClimateIndexNo(String climateIndexNo) {
        this.climateIndexNo = climateIndexNo;
    }

    public String getClimateIndexName() {
        return climateIndexName;
    }

    public void setClimateIndexName(String climateIndexName) {
        this.climateIndexName = climateIndexName;
    }

    public String getClimateIndexValue() {
        return climateIndexValue;
    }

    public void setClimateIndexValue(String climateIndexValue) {
        this.climateIndexValue = climateIndexValue;
    }

    public Double getCcIndex() {
        return ccIndex;
    }

    public void setCcIndex(Double ccIndex) {
        this.ccIndex = ccIndex;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SelectedFactors{" +
                ", id=" + id +
                ", forecastSection=" + forecastSection +
                ", forecastTimeStart=" + forecastTimeStart +
                ", forecastTime=" + forecastTime +
                ", yearNo=" + yearNo +
                ", monthNo=" + monthNo +
                ", climateIndexNo=" + climateIndexNo +
                ", climateIndexName=" + climateIndexName +
                ", climateIndexValue=" + climateIndexValue +
                ", ccIndex=" + ccIndex +
                "}";
    }
}
