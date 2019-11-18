package com.anka.apps.model;

import java.util.Date;

import javax.persistence.Id;

import com.anka.base.annotation.FCMD;
import com.anka.base.annotation.FCMD.CMM;
import com.anka.base.model.BaseModel;
/**
 * @Description:(CoreGrant)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreGrant extends BaseModel<CoreGrant> {

	/** UUID */
	@Id
	@FCMD(fieldName="crgrUuid",type=CMM.UUID)
	private String crgrUuid;
	/** 权限名称 */
	@FCMD(fieldName="crgrName",type=CMM.TEXT)
	private String crgrName;
	/** 权限值 */
	private String crgrKey;
	/** 权限描述 */
	private String crgrNote;
	/** 状态 */
	@FCMD(fieldName="crgrStatus",type=CMM.STATUS)
	private String crgrStatus;
	/** 创建时间 */
	@FCMD(fieldName="crgrCdate",type=CMM.CDATE)
	private Date crgrCdate;
	/** 修改时间 */
	@FCMD(fieldName="crgrUdate",type=CMM.UDATE)
	private Date crgrUdate;
	/** 排序 */
	@FCMD(fieldName="crgrOrd",type=CMM.ORDER)
	private Integer crgrOrd;

	public String getCrgrUuid() {
		return crgrUuid;
	}
	public void setCrgrUuid(String crgrUuid) {
		this.crgrUuid = crgrUuid;
	}
	public String getCrgrName() {
		return crgrName;
	}
	public void setCrgrName(String crgrName) {
		this.crgrName = crgrName;
	}
	public String getCrgrKey() {
		return crgrKey;
	}
	public void setCrgrKey(String crgrKey) {
		this.crgrKey = crgrKey;
	}
	public String getCrgrNote() {
		return crgrNote;
	}
	public void setCrgrNote(String crgrNote) {
		this.crgrNote = crgrNote;
	}
	public String getCrgrStatus() {
		return crgrStatus;
	}
	public void setCrgrStatus(String crgrStatus) {
		this.crgrStatus = crgrStatus;
	}
	public Date getCrgrCdate() {
		return crgrCdate;
	}
	public void setCrgrCdate(Date crgrCdate) {
		this.crgrCdate = crgrCdate;
	}
	public Date getCrgrUdate() {
		return crgrUdate;
	}
	public void setCrgrUdate(Date crgrUdate) {
		this.crgrUdate = crgrUdate;
	}
	public Integer getCrgrOrd() {
		return crgrOrd;
	}
	public void setCrgrOrd(Integer crgrOrd) {
		this.crgrOrd = crgrOrd;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("crgrUuid(UUID):").append(crgrUuid+" ");
		bf.append("crgrName(权限名称):").append(crgrName+" ");
		bf.append("crgrKey(权限值):").append(crgrKey+" ");
		bf.append("\n");
		bf.append("crgrNote(权限描述):").append(crgrNote+" ");
		bf.append("crgrStatus(状态):").append(crgrStatus+" ");
		bf.append("crgrCdate(创建时间):").append(crgrCdate+" ");
		bf.append("\n");
		bf.append("crgrUdate(修改时间):").append(crgrUdate+" ");
		bf.append("crgrOrd(排序):").append(crgrOrd+" ");
		return bf.toString();
	}
	
}
