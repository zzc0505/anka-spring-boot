package com.anka.apps.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.anka.base.annotation.FCMD;
import com.anka.base.annotation.FCMD.CMM;
import com.anka.base.model.BaseModel;

/**
 * @Description:用户表(CoreUser)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreUser extends BaseModel<CoreUser> {

	/** uuid */
	@Id
	@FCMD(fieldName="crurUuid",type=CMM.UUID)
	private String crurUuid;
	/** 用户名 */
	@FCMD(fieldName="crurName",type=CMM.TEXT)
	private String crurName;
	/** 用户密码  */
	private String crurPassword;
	/** 性别 1男2女3保密*/
	private String crurSex;
	/** 手机号码 */
	private String crurMobile;
	/** 固话号码 */
	private String crurTel;
	/** 邮件地址 */
	private String crurEmail;
	/** 职务 */
	private String crurPost;
	/** 所属机构uuid */
	private String crurCrorUuid;
	/** 所属机构name */
	private String crurCrorName;
	/** 登陆方式 */
	private String crurLogtype;
	/** 用户状态 0启用1禁用*/
	@FCMD(fieldName="crurStatus",type=CMM.STATUS)
	private String crurStatus;
	/** 排序号 */
	@FCMD(fieldName="crurOrd",type=CMM.ORDER)
	private Integer crurOrd;
	/** 锁屏密码 */
	private String crurLockpassword;
	/** 用户性质 */
	private String crurNature;
	/** 拼音简写 */
	private String crurPinyin;
	/** 密码过期时间 */
	private Date crurPasswordexptime;
	/** 创建时间 */
	@FCMD(fieldName="crurCdate",type=CMM.CDATE)
	private Date crurCdate;
	/** 修改时间 */
	@FCMD(fieldName="crurUdate",type=CMM.UDATE)
	private Date crurUdate;
	/** 备注 */
	private String crurRemarkers;
	/** 锁屏状态 0未锁1已锁 */
	private String crurLockstatus;
	/** 角色集合 */
	@Transient
	private Set<String> coreRole;
	/** 权限集合 */
	@Transient
	private Set<String> coreGrant;
	
	public String getCrurUuid() {
		return crurUuid;
	}
	public void setCrurUuid(String crurUuid) {
		this.crurUuid = crurUuid;
	}
	public String getCrurName() {
		return crurName;
	}
	public void setCrurName(String crurName) {
		this.crurName = crurName;
	}
	public String getCrurPassword() {
		return crurPassword;
	}
	public void setCrurPassword(String crurPassword) {
		this.crurPassword = crurPassword;
	}
	public String getCrurSex() {
		return crurSex;
	}
	public void setCrurSex(String crurSex) {
		this.crurSex = crurSex;
	}
	public String getCrurMobile() {
		return crurMobile;
	}
	public void setCrurMobile(String crurMobile) {
		this.crurMobile = crurMobile;
	}
	public String getCrurTel() {
		return crurTel;
	}
	public void setCrurTel(String crurTel) {
		this.crurTel = crurTel;
	}
	public String getCrurEmail() {
		return crurEmail;
	}
	public void setCrurEmail(String crurEmail) {
		this.crurEmail = crurEmail;
	}
	public String getCrurPost() {
		return crurPost;
	}
	public void setCrurPost(String crurPost) {
		this.crurPost = crurPost;
	}
	public String getCrurCrorUuid() {
		return crurCrorUuid;
	}
	public void setCrurCrorUuid(String crurCrorUuid) {
		this.crurCrorUuid = crurCrorUuid;
	}
	public String getCrurCrorName() {
		return crurCrorName;
	}
	public void setCrurCrorName(String crurCrorName) {
		this.crurCrorName = crurCrorName;
	}
	public String getCrurLogtype() {
		return crurLogtype;
	}
	public void setCrurLogtype(String crurLogtype) {
		this.crurLogtype = crurLogtype;
	}
	public String getCrurStatus() {
		return crurStatus;
	}
	public void setCrurStatus(String crurStatus) {
		this.crurStatus = crurStatus;
	}
	public Integer getCrurOrd() {
		return crurOrd;
	}
	public void setCrurOrd(Integer crurOrd) {
		this.crurOrd = crurOrd;
	}
	public String getCrurLockpassword() {
		return crurLockpassword;
	}
	public void setCrurLockpassword(String crurLockpassword) {
		this.crurLockpassword = crurLockpassword;
	}
	public String getCrurNature() {
		return crurNature;
	}
	public void setCrurNature(String crurNature) {
		this.crurNature = crurNature;
	}
	public String getCrurPinyin() {
		return crurPinyin;
	}
	public void setCrurPinyin(String crurPinyin) {
		this.crurPinyin = crurPinyin;
	}
	public Date getCrurPasswordexptime() {
		return crurPasswordexptime;
	}
	public void setCrurPasswordexptime(Date crurPasswordexptime) {
		this.crurPasswordexptime = crurPasswordexptime;
	}
	public Date getCrurCdate() {
		return crurCdate;
	}
	public void setCrurCdate(Date crurCdate) {
		this.crurCdate = crurCdate;
	}
	public Date getCrurUdate() {
		return crurUdate;
	}
	public void setCrurUdate(Date crurUdate) {
		this.crurUdate = crurUdate;
	}
	public String getCrurRemarkers() {
		return crurRemarkers;
	}
	public void setCrurRemarkers(String crurRemarkers) {
		this.crurRemarkers = crurRemarkers;
	}
	public String getCrurLockstatus() {
		return crurLockstatus;
	}
	public void setCrurLockstatus(String crurLockstatus) {
		this.crurLockstatus = crurLockstatus;
	}
	public Set<String> getCoreRole() {
		return this.coreRole = this.coreRole == null? new LinkedHashSet<String>():this.coreRole;
	}
	public void setCoreRole(Set<String> coreRole) {
		this.coreRole = coreRole;
	}
	public Set<String> getCoreGrant() {
		return this.coreGrant = this.coreGrant == null? new LinkedHashSet<String>():this.coreGrant;
	}
	public void setCoreGrant(Set<String> coreGrant) {
		this.coreGrant = coreGrant;
	}
	
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("crurUuid(uuid):").append(crurUuid+" ");
		bf.append("crurName(用户名):").append(crurName+" ");
		bf.append("crurPassword(用户密码 ):").append(crurPassword+" ");
		bf.append("\n");
		bf.append("crurSex(性别):").append(crurSex+" ");
		bf.append("crurMobile(手机号码):").append(crurMobile+" ");
		bf.append("crurTel(固话号码):").append(crurTel+" ");
		bf.append("\n");
		bf.append("crurEmail(邮件地址):").append(crurEmail+" ");
		bf.append("crurPost(职务):").append(crurPost+" ");
		bf.append("crurCrorUuid(所属机构uuid):").append(crurCrorUuid+" ");
		bf.append("\n");
		bf.append("crurCrorName(所属机构name):").append(crurCrorName+" ");
		bf.append("crurLogtype(登陆方式):").append(crurLogtype+" ");
		bf.append("crurStatus(用户状态):").append(crurStatus+" ");
		bf.append("\n");
		bf.append("crurOrd(排序号):").append(crurOrd+" ");
		bf.append("crurLockpassword(锁屏密码):").append(crurLockpassword+" ");
		bf.append("crurNature(用户性质):").append(crurNature+" ");
		bf.append("\n");
		bf.append("crurPinyin(拼音简写):").append(crurPinyin+" ");
		bf.append("crurPasswordexptime(密码过期时间):").append(crurPasswordexptime+" ");
		bf.append("crurCdate(创建时间):").append(crurCdate+" ");
		bf.append("\n");
		bf.append("crurUdate(修改时间):").append(crurUdate+" ");
		bf.append("crurRemarkers(备注):").append(crurRemarkers+" ");
		bf.append("crurLockstatus(锁屏状态 0未锁1已锁):").append(crurLockstatus+" ");
		return bf.toString();
	}
	
}
