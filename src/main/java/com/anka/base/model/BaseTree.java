package com.anka.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public class BaseTree<T extends BaseModel<T>> extends BaseModel<T> implements Serializable {
	
	private static final long serialVersionUID = 5601493892048597045L;
	
	/** 节点ID */
	@Transient
	private String id;
	/** 上级节点ID */
	@Transient
	private String parentId;
	/** 节点名称 */
	@Transient
	private String title;
	/** 是否展开节点 */
	@Transient
	private Boolean spread;
	/** 是否最后一级节点 */
	@Transient
	private Boolean last;
	/** 是否隐藏*/
	@Transient
	private Boolean hide;
	/** 是否禁用*/
	@Transient
	private Boolean disabled;
	/** 自定义图标class */
	@Transient
	private String iconClass;
	/** 表示用户自定义需要存储在树节点中的数据 */
	@Transient
	private Object basicData;
	/** 复选框0未选中1选中 */
	@Transient
	private String CheckArr;
	/** 子节点集合 */
	@Transient
	private List<T> children = new ArrayList<T>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getSpread() {
		return spread;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	public Boolean getHide() {
		return hide;
	}
	public void setHide(Boolean hide) {
		this.hide = hide;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	public Object getBasicData() {
		return basicData;
	}
	public void setBasicData(Object basicData) {
		this.basicData = basicData;
	}
	public String getCheckArr() {
		return CheckArr;
	}
	public void setCheckArr(String checkArr) {
		CheckArr = checkArr;
	}
	public List<T> getChildren() {
		return children;
	}
	public void setChildren(List<T> children) {
		this.children = children;
	}
	
}
