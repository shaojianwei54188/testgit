package com.hhu.mlthfs.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author HHU
 * @since 2018-08-02
 */
@TableName("ST_RVAV_R")
public class RvavR extends Model<RvavR> {

    private static final long serialVersionUID = 1L;

	private String stcd;
	private Date idtm;
	private String sttdrcd;
	private Double avz;
	private Double avq;


	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public Date getIdtm() {
		return idtm;
	}

	public void setIdtm(Date idtm) {
		this.idtm = idtm;
	}

	public String getSttdrcd() {
		return sttdrcd;
	}

	public void setSttdrcd(String sttdrcd) {
		this.sttdrcd = sttdrcd;
	}

	public Double getAvz() {
		return avz;
	}

	public void setAvz(Double avz) {
		this.avz = avz;
	}

	public Double getAvq() {
		return avq;
	}

	public void setAvq(Double avq) {
		this.avq = avq;
	}

	@Override
	protected Serializable pkVal() {
		return this.stcd;
	}

	@Override
	public String toString() {
		return "RvavR{" +
			", stcd=" + stcd +
			", idtm=" + idtm +
			", sttdrcd=" + sttdrcd +
			", avz=" + avz +
			", avq=" + avq +
			"}";
	}
}
