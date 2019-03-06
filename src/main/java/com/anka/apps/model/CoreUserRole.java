package com.anka.apps.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.anka.base.model.BaseModel;

/**
 * @Description:用户角色关联表(CoreUserRole)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreUserRole extends BaseModel<CoreUserRole> {

	/** UUID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "SELECT UPPER(REPLACE(UUID(),'-',''))")
	private String crueUuid;
	/** 用户UUID */
	private String crueCrurUuid;
	/** 角色UUID */
	private String crueCrreUuid;

	public String getCrueUuid() {
		return crueUuid;
	}
	public void setCrueUuid(String crueUuid) {
		this.crueUuid = crueUuid;
	}
	public String getCrueCrurUuid() {
		return crueCrurUuid;
	}
	public void setCrueCrurUuid(String crueCrurUuid) {
		this.crueCrurUuid = crueCrurUuid;
	}
	public String getCrueCrreUuid() {
		return crueCrreUuid;
	}
	public void setCrueCrreUuid(String crueCrreUuid) {
		this.crueCrreUuid = crueCrreUuid;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("crueUuid(UUID):").append(crueUuid+" ");
		bf.append("crueCrurUuid(用户UUID):").append(crueCrurUuid+" ");
		bf.append("crueCrreUuid(角色UUID):").append(crueCrreUuid+" ");
		return bf.toString();
	}
	
}
