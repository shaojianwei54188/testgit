package com.hhu.mlthfs.model.vo;

/**
 *
 * 用于存放水情数据的vo
 *
 * 月平均值
 */
public class WaterInfoVo {
    private String stcd;
    private String sttp;
    private String stnm;

    private Double riverAvz;
    private Double riverAvq;
    private Double rsvrAvrz;
    private Double rsvrAvinq;
    private Double rsvrAvotq;
    private Double rsvrAvw;

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    public String getSttp() {
        return sttp;
    }

    public void setSttp(String sttp) {
        this.sttp = sttp;
    }

    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }

    public Double getRiverAvz() {
        return riverAvz;
    }

    public void setRiverAvz(Double riverAvz) {
        this.riverAvz = riverAvz;
    }

    public Double getRiverAvq() {
        return riverAvq;
    }

    public void setRiverAvq(Double riverAvq) {
        this.riverAvq = riverAvq;
    }

    public Double getRsvrAvrz() {
        return rsvrAvrz;
    }

    public void setRsvrAvrz(Double rsvrAvrz) {
        this.rsvrAvrz = rsvrAvrz;
    }

    public Double getRsvrAvinq() {
        return rsvrAvinq;
    }

    public void setRsvrAvinq(Double rsvrAvinq) {
        this.rsvrAvinq = rsvrAvinq;
    }

    public Double getRsvrAvotq() {
        return rsvrAvotq;
    }

    public void setRsvrAvotq(Double rsvrAvotq) {
        this.rsvrAvotq = rsvrAvotq;
    }

    public Double getRsvrAvw() {
        return rsvrAvw;
    }

    public void setRsvrAvw(Double rsvrAvw) {
        this.rsvrAvw = rsvrAvw;
    }

    public WaterInfoVo() {
    }

    public WaterInfoVo(String stcd, String sttp, String stnm, Double riverAvz, Double riverAvq, Double rsvrAvrz, Double rsvrAvinq, Double rsvrAvotq, Double rsvrAvw) {
        this.stcd = stcd;
        this.sttp = sttp;
        this.stnm = stnm;
        this.riverAvz = riverAvz;
        this.riverAvq = riverAvq;
        this.rsvrAvrz = rsvrAvrz;
        this.rsvrAvinq = rsvrAvinq;
        this.rsvrAvotq = rsvrAvotq;
        this.rsvrAvw = rsvrAvw;
    }

    @Override
    public String toString() {
        return "WaterInfoVo{" +
                "stcd='" + stcd + '\'' +
                ", sttp='" + sttp + '\'' +
                ", stnm='" + stnm + '\'' +
                ", riverAvz=" + riverAvz +
                ", riverAvq=" + riverAvq +
                ", rsvrAvrz=" + rsvrAvrz +
                ", rsvrAvinq=" + rsvrAvinq +
                ", rsvrAvotq=" + rsvrAvotq +
                ", rsvrAvw=" + rsvrAvw +
                '}';
    }
}
