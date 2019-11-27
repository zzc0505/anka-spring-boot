package com.anka.apps.model;

import javax.persistence.Id;

import com.anka.base.model.BaseModel;
/**
 * @Description:(CoreSeq)模型对象
 * @author AnkaRebirth
 * @version 1.0.0
 */
public class CoreSeq extends BaseModel<CoreSeq> {

	/** 序列名 */
	@Id
	private String name;
	/** 初始值 */
	private Integer startValue;
	/** 步长 */
	private Integer incrementValue;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStartValue() {
		return startValue;
	}
	public void setStartValue(Integer startValue) {
		this.startValue = startValue;
	}
	public Integer getIncrementValue() {
		return incrementValue;
	}
	public void setIncrementValue(Integer incrementValue) {
		this.incrementValue = incrementValue;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n");
		bf.append("name(序列名):").append(name+" ");
		bf.append("startValue(初始值):").append(startValue+" ");
		bf.append("incrementValue(步长):").append(incrementValue+" ");
		return bf.toString();
	}
	
}
