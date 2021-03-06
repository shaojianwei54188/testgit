package com.hhu.mlthfs.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author HHU
 * @since 2018-10-13
 */
@TableName("plan_info")
@KeySequence(value = "plan_info_sq", clazz = Long.class)
public class PlanInfo extends Model<PlanInfo> {

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
     * 终止时间（起报时间向后延伸12月）
     */
    private String forecastTimeEnd;
    /**
     * 方案编号，唯一标识符
     */
    private String planId;
    /**
     * 方案类型（0：单模型，1：多模型）
     */
    private Integer planType;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 是否预报（0：否，1：是）
     */
    private Integer isForecast;
    /**
     * 是否校正（0：否，1：是）
     */
    private Integer isAdjust;
    /**
     * 是否可靠性评估（0：否，1：是）
     */
    private Integer isAssess;
    /**
     * 方案存放路径
     */
    private String planPath;
    private Long createBy;
    private Date createDate;
    private Long updateBy;
    private Date updateDate;
    private Integer delFlag;
    private String remarks;
    /**
     * 预报断面站码
     */
    private String stcd;
    /**
     * 是否综合（0：否，1：是）
     */
    private Integer isCombine;


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

    public String getForecastTimeEnd() {
        return forecastTimeEnd;
    }

    public void setForecastTimeEnd(String forecastTimeEnd) {
        this.forecastTimeEnd = forecastTimeEnd;
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

    public Integer getIsForecast() {
        return isForecast;
    }

    public void setIsForecast(Integer isForecast) {
        this.isForecast = isForecast;
    }

    public Integer getIsAdjust() {
        return isAdjust;
    }

    public void setIsAdjust(Integer isAdjust) {
        this.isAdjust = isAdjust;
    }

    public Integer getIsAssess() {
        return isAssess;
    }

    public void setIsAssess(Integer isAssess) {
        this.isAssess = isAssess;
    }

    public String getPlanPath() {
        return planPath;
    }

    public void setPlanPath(String planPath) {
        this.planPath = planPath;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
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

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    public Integer getIsCombine() {
        return isCombine;
    }

    public void setIsCombine(Integer isCombine) {
        this.isCombine = isCombine;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PlanInfo{" +
                ", id=" + id +
                ", forecastSection=" + forecastSection +
                ", forecastTimeStart=" + forecastTimeStart +
                ", forecastTimeEnd=" + forecastTimeEnd +
                ", planId=" + planId +
                ", planType=" + planType +
                ", modelName=" + modelName +
                ", isForecast=" + isForecast +
                ", isAdjust=" + isAdjust +
                ", isAssess=" + isAssess +
                ", planPath=" + planPath +
                ", createBy=" + createBy +
                ", createDate=" + createDate +
                ", updateBy=" + updateBy +
                ", updateDate=" + updateDate +
                ", delFlag=" + delFlag +
                ", remarks=" + remarks +
                ", stcd=" + stcd +
                ", isCombine=" + isCombine +
                "}";
    }
}
