package com.hhu.mlthfs.model;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author HHU
 * @since 2018-10-15
 */
@TableName("plan_assess_index")
public class PlanAssessIndex extends Model<PlanAssessIndex> {

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
     * 起报时间（预报出来一年结果中的第一个月）
     */
    private String forecastTimeStart;
    /**
     * 率定期10%合格率
     */
    private Double train10;
    /**
     * 率定期20%
     */
    private Double train20;
    /**
     * 率定期三级
     */
    private Double train3;
    /**
     * 验证期10%
     */
    private Double test10;
    /**
     * 验证期20%
     */
    private Double test20;
    /**
     * 验证期三级
     */
    private Double test3;
    /**
     * 率定期五级
     */
    private Double train5;
    private Integer createBy;
    private Date createDate;
    private Long updateBy;
    private Date updateDate;
    private Integer delFlag;
    private String remarks;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 验证期五级
     */
    private Double test5;


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

    public Double getTrain10() {
        return train10;
    }

    public void setTrain10(Double train10) {
        this.train10 = train10;
    }

    public Double getTrain20() {
        return train20;
    }

    public void setTrain20(Double train20) {
        this.train20 = train20;
    }

    public Double getTrain3() {
        return train3;
    }

    public void setTrain3(Double train3) {
        this.train3 = train3;
    }

    public Double getTest10() {
        return test10;
    }

    public void setTest10(Double test10) {
        this.test10 = test10;
    }

    public Double getTest20() {
        return test20;
    }

    public void setTest20(Double test20) {
        this.test20 = test20;
    }

    public Double getTest3() {
        return test3;
    }

    public void setTest3(Double test3) {
        this.test3 = test3;
    }

    public Double getTrain5() {
        return train5;
    }

    public void setTrain5(Double train5) {
        this.train5 = train5;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getTest5() {
        return test5;
    }

    public void setTest5(Double test5) {
        this.test5 = test5;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PlanAssessIndex{" +
                ", id=" + id +
                ", planId=" + planId +
                ", forecastSection=" + forecastSection +
                ", forecastTimeStart=" + forecastTimeStart +
                ", train10=" + train10 +
                ", train20=" + train20 +
                ", train3=" + train3 +
                ", test10=" + test10 +
                ", test20=" + test20 +
                ", test3=" + test3 +
                ", train5=" + train5 +
                ", createBy=" + createBy +
                ", createDate=" + createDate +
                ", updateBy=" + updateBy +
                ", updateDate=" + updateDate +
                ", delFlag=" + delFlag +
                ", remarks=" + remarks +
                ", modelName=" + modelName +
                ", test5=" + test5 +
                "}";
    }
}
