package com.hhu.mlthfs.model.vo;

/**
 * 展示预报距平
 */
public class ForecastDepartureVo {

    private String forecastTime;

    private float rf;
    private float svm;
    private float sap;
    private float mr;
    private float wa;
    private float bma;
    private float hup;

    public String getForecastTime() {
        return forecastTime;
    }

    public void setForecastTime(String forecastTime) {
        this.forecastTime = forecastTime;
    }

    public float getRf() {
        return rf;
    }

    public void setRf(float rf) {
        this.rf = rf;
    }

    public float getSvm() {
        return svm;
    }

    public void setSvm(float svm) {
        this.svm = svm;
    }

    public float getSap() {
        return sap;
    }

    public void setSap(float sap) {
        this.sap = sap;
    }

    public float getMr() {
        return mr;
    }

    public void setMr(float mr) {
        this.mr = mr;
    }

    public float getWa() {
        return wa;
    }

    public void setWa(float wa) {
        this.wa = wa;
    }

    public float getBma() {
        return bma;
    }

    public void setBma(float bma) {
        this.bma = bma;
    }

    public float getHup() {
        return hup;
    }

    public void setHup(float hup) {
        this.hup = hup;
    }

    public ForecastDepartureVo() {
    }

    public ForecastDepartureVo(String forecastTime, float rf, float svm, float sap, float mr, float wa, float bma, float hup) {
        this.forecastTime = forecastTime;
        this.rf = rf;
        this.svm = svm;
        this.sap = sap;
        this.mr = mr;
        this.wa = wa;
        this.bma = bma;
        this.hup = hup;
    }
}
