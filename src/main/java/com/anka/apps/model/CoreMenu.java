package com.anka.apps.model;

import java.util.Date;

import javax.persistence.Id;

import com.anka.base.annotation.FCMD;
import com.anka.base.annotation.FCMD.CMM;
import com.anka.base.model.BaseTree;
/**
 * @Description:(CoreMenu)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreMenu extends BaseTree<CoreMenu> {

	/** UUID */
	@Id
	@FCMD(fieldName="crmeUuid",type=CMM.UUID)
	private String crmeUuid;
	/** 父UUID */
	private String crmeParentUuid;
	/** 菜单名称 */
	@FCMD(fieldName="crmeName",type=CMM.TEXT)
	private String crmeName;
	/** 菜单URL */
	private String crmeUrl;
	/** 展示方式 */
	private String crmeTarget;
	/** 图标CLASS */
	private String crmeIcon;
	/** 菜单类型 */
	private String crmeType;
	/** 状态 */
	private String crmeStatus;
	/** 创建时间 */
	@FCMD(fieldName="crmeCdate",type=CMM.CDATE)
	private Date crmeCdate;
	/** 修改时间 */
	@FCMD(fieldName="crmeUdate",type=CMM.UDATE)
	private Date crmeUdate;
	/** 排序 */
	private Integer crmeOrd;
	/** 备注 */
	private String crmeRemark;

	public String getCrmeUuid() {
		return crmeUuid;
	}
	public void setCrmeUuid(String crmeUuid) {
		this.crmeUuid = crmeUuid;
	}
	public String getCrmeParentUuid() {
		return crmeParentUuid;
	}
	public void setCrmeParentUuid(String crmeParentUuid) {
		this.crmeParentUuid = crmeParentUuid;
	}
	public String getCrmeName() {
		return crmeName;
	}
	public void setCrmeName(String crmeName) {
		this.crmeName = crmeName;
	}
	public String getCrmeUrl() {
		return crmeUrl;
	}
	public void setCrmeUrl(String crmeUrl) {
		this.crmeUrl = crmeUrl;
	}
	public String getCrmeTarget() {
		return crmeTarget;
	}
	public void setCrmeTarget(String crmeTarget) {
		this.crmeTarget = crmeTarget;
	}
	public String getCrmeIcon() {
		return crmeIcon;
	}
	public void setCrmeIcon(String crmeIcon) {
		this.crmeIcon = crmeIcon;
	}
	public String getCrmeType() {
		return crmeType;
	}
	public void setCrmeType(String crmeType) {
		this.crmeType = crmeType;
	}
	public String getCrmeStatus() {
		return crmeStatus;
	}
	public void setCrmeStatus(String crmeStatus) {
		this.crmeStatus = crmeStatus;
	}
	public Date getCrmeCdate() {
		return crmeCdate;
	}
	public void setCrmeCdate(Date crmeCdate) {
		this.crmeCdate = crmeCdate;
	}
	public Date getCrmeUdate() {
		return crmeUdate;
	}
	public void setCrmeUdate(Date crmeUdate) {
		this.crmeUdate = crmeUdate;
	}
	public Integer getCrmeOrd() {
		return crmeOrd;
	}
	public void setCrmeOrd(Integer crmeOrd) {
		this.crmeOrd = crmeOrd;
	}
	public String getCrmeRemark() {
		return crmeRemark;
	}
	public void setCrmeRemark(String crmeRemark) {
		this.crmeRemark = crmeRemark;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("crmeUuid(UUID):").append(crmeUuid+" ");
		bf.append("crmeParentUuid(父UUID):").append(crmeParentUuid+" ");
		bf.append("crmeName(菜单名称):").append(crmeName+" ");
		bf.append("\n");
		bf.append("crmeUrl(菜单URL):").append(crmeUrl+" ");
		bf.append("crmeTarget(展示方式):").append(crmeTarget+" ");
		bf.append("crmeIcon(图标CLASS):").append(crmeIcon+" ");
		bf.append("\n");
		bf.append("crmeType(菜单类型):").append(crmeType+" ");
		bf.append("crmeStatus(状态):").append(crmeStatus+" ");
		bf.append("crmeCdate(创建时间):").append(crmeCdate+" ");
		bf.append("\n");
		bf.append("crmeUdate(修改时间):").append(crmeUdate+" ");
		bf.append("crmeOrd(排序):").append(crmeOrd+" ");
		bf.append("crmeRemark(备注):").append(crmeRemark+" ");
		return bf.toString();
	}
	
}
