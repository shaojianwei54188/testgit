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
 * @since 2018-10-31
 */
@TableName("HISTORY_Q_DATA")
@KeySequence(value = "HISTORY_Q_DATA_sq")
public class HistoryQData extends Model<HistoryQData> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String stcd;
    private String forecastSection;
    private String tm;
    private Double monthQ;
    private Double monthAverageQ;
    private Double monthMaxQ;
    private Double monthMinQ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    public String getForecastSection() {
        return forecastSection;
    }

    public void setForecastSection(String forecastSection) {
        this.forecastSection = forecastSection;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public Double getMonthQ() {
        return monthQ;
    }

    public void setMonthQ(Double monthQ) {
        this.monthQ = monthQ;
    }

    public Double getMonthAverageQ() {
        return monthAverageQ;
    }

    public void setMonthAverageQ(Double monthAverageQ) {
        this.monthAverageQ = monthAverageQ;
    }

    public Double getMonthMaxQ() {
        return monthMaxQ;
    }

    public void setMonthMaxQ(Double monthMaxQ) {
        this.monthMaxQ = monthMaxQ;
    }

    public Double getMonthMinQ() {
        return monthMinQ;
    }

    public void setMonthMinQ(Double monthMinQ) {
        this.monthMinQ = monthMinQ;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "HistoryQData{" +
                ", id=" + id +
                ", stcd=" + stcd +
                ", forecastSection=" + forecastSection +
                ", tm=" + tm +
                ", monthQ=" + monthQ +
                ", monthAverageQ=" + monthAverageQ +
                ", monthMaxQ=" + monthMaxQ +
                ", monthMinQ=" + monthMinQ +
                "}";
    }
}
