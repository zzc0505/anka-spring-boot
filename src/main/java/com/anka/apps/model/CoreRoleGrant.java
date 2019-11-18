package com.anka.apps.model;

import java.util.Date;

import javax.persistence.Id;

import com.anka.base.annotation.FCMD;
import com.anka.base.annotation.FCMD.CMM;
import com.anka.base.model.BaseModel;
/**
 * @Description:(CoreRoleGrant)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreRoleGrant extends BaseModel<CoreRoleGrant> {

	/** UUID */
	@Id
	@FCMD(fieldName="crrgUuid",type=CMM.UUID)
	private String crrgUuid;
	/** 角色UUID */
	private String crrgCrreUuid;
	/** 权限UUID */
	private String crrgCrgrUuid;

	public String getCrrgUuid() {
		return crrgUuid;
	}
	public void setCrrgUuid(String crrgUuid) {
		this.crrgUuid = crrgUuid;
	}
	public String getCrrgCrreUuid() {
		return crrgCrreUuid;
	}
	public void setCrrgCrreUuid(String crrgCrreUuid) {
		this.crrgCrreUuid = crrgCrreUuid;
	}
	public String getCrrgCrgrUuid() {
		return crrgCrgrUuid;
	}
	public void setCrrgCrgrUuid(String crrgCrgrUuid) {
		this.crrgCrgrUuid = crrgCrgrUuid;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("crrgUuid(UUID):").append(crrgUuid+" ");
		bf.append("crrgCrreUuid(角色UUID):").append(crrgCrreUuid+" ");
		bf.append("crrgCrgrUuid(权限UUID):").append(crrgCrgrUuid+" ");
		return bf.toString();
	}
	
}
