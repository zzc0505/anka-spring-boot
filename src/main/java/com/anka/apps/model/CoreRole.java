package com.anka.apps.model;

import java.util.Date;

import javax.persistence.Id;

import com.anka.base.annotation.FCMD;
import com.anka.base.annotation.FCMD.CMM;
import com.anka.base.model.BaseModel;
/**
 * @Description:(CoreRole)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreRole extends BaseModel<CoreRole> {

	/** UUID */
	@Id
	@FCMD(fieldName="crreUuid",type=CMM.UUID)
	private String crreUuid;
	/** 角色名 */
	@FCMD(fieldName="crreName",type=CMM.TEXT)
	private String crreName;
	/** 唯一标识 */
	private String crreKey;
	/** 角色说明 */
	private String crreNote;
	/** 状态 */
	@FCMD(fieldName="crreStatus",type=CMM.STATUS)
	private String crreStatus;
	/** 创建时间 */
	@FCMD(fieldName="crreCdate",type=CMM.CDATE)
	private Date crreCdate;
	/** 修改时间 */
	@FCMD(fieldName="crreUdate",type=CMM.UDATE)
	private Date crreUdate;
	/** 排序号 */
	@FCMD(fieldName="crreOrd",type=CMM.ORDER)
	private Integer crreOrd;

	public String getCrreUuid() {
		return crreUuid;
	}
	public void setCrreUuid(String crreUuid) {
		this.crreUuid = crreUuid;
	}
	public String getCrreName() {
		return crreName;
	}
	public void setCrreName(String crreName) {
		this.crreName = crreName;
	}
	public String getCrreKey() {
		return crreKey;
	}
	public void setCrreKey(String crreKey) {
		this.crreKey = crreKey;
	}
	public String getCrreNote() {
		return crreNote;
	}
	public void setCrreNote(String crreNote) {
		this.crreNote = crreNote;
	}
	public String getCrreStatus() {
		return crreStatus;
	}
	public void setCrreStatus(String crreStatus) {
		this.crreStatus = crreStatus;
	}
	public Date getCrreCdate() {
		return crreCdate;
	}
	public void setCrreCdate(Date crreCdate) {
		this.crreCdate = crreCdate;
	}
	public Date getCrreUdate() {
		return crreUdate;
	}
	public void setCrreUdate(Date crreUdate) {
		this.crreUdate = crreUdate;
	}
	public Integer getCrreOrd() {
		return crreOrd;
	}
	public void setCrreOrd(Integer crreOrd) {
		this.crreOrd = crreOrd;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("crreUuid(UUID):").append(crreUuid+" ");
		bf.append("crreName(角色名):").append(crreName+" ");
		bf.append("crreKey(唯一标识):").append(crreKey+" ");
		bf.append("\n");
		bf.append("crreNote(角色说明):").append(crreNote+" ");
		bf.append("crreStatus(状态):").append(crreStatus+" ");
		bf.append("crreCdate(创建时间):").append(crreCdate+" ");
		bf.append("\n");
		bf.append("crreUdate(修改时间):").append(crreUdate+" ");
		bf.append("crreOrd(排序号):").append(crreOrd+" ");
		return bf.toString();
	}
	
}
