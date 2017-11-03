package com.yiyouya.epin.pingtai.framework.entity;

import java.io.Serializable;

/**
 * Role entity.
 * 
 * @author liuhh
 */
 

public class Operation    implements Comparable<Operation>, Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String chineseName;
	//default value
	private Integer parentId = 0;
	private int sort;
	private String type;
	private String uri;
	private String icon;

	public Operation() {
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}


	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public int compareTo(Operation that) {
		return new Integer(this.id).compareTo(that.id);
	}


	public String getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}
	public void setIcon(String icon) {
		// TODO Auto-generated method stub
		this.icon = icon;
	}

}

