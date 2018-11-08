package com.hhu.mlthfs.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hhu.mlthfs.base.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 气候因子名称索引表
 * </p>
 *
 * @author HHU
 * @since 2018-07-24
 */
@TableName("climate_name")
@KeySequence(value = "climate_name_sq",clazz = Long.class)
public class ClimateName extends DataEntity<ClimateName> {

    private static final long serialVersionUID = 1L;

    /**
     * 气候因子id
     */
    @TableField("id")
	private Long id;
    /**
     * 气候因子编号C+序号，序号：1-130
     */
    @TableField("climate_number")
	private String climateNumber;
    /**
     * 气候因子的中文名称（zh_cn代表中文简体）
     */
    @TableField("climate_name_zhcn")
	private String climateNameZhcn;
    /**
     * 气候因子的英文名称（en代表英文）
     */
    @TableField("climate_name_en")
	private String climateNameEn;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClimateNumber() {
		return climateNumber;
	}

	public void setClimateNumber(String climateNumber) {
		this.climateNumber = climateNumber;
	}

	public String getClimateNameZhcn() {
		return climateNameZhcn;
	}

	public void setClimateNameZhcn(String climateNameZhcn) {
		this.climateNameZhcn = climateNameZhcn;
	}

	public String getClimateNameEn() {
		return climateNameEn;
	}

	public void setClimateNameEn(String climateNameEn) {
		this.climateNameEn = climateNameEn;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ClimateName{" +
			", id=" + id +
			", climateNumber=" + climateNumber +
			", climateNameZhcn=" + climateNameZhcn +
			", climateNameEn=" + climateNameEn +
			"}";
	}
}
