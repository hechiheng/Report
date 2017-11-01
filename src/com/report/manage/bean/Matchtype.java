package com.report.manage.bean;

import java.io.Serializable;

public class Matchtype implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String orgcode;
	private String name;
	private String description;
	private int isvalid;
	private int isdisabled;
	private String updatetime;
	private int userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setIsdisabled(int isdisabled) {
		this.isdisabled = isdisabled;
	}

	public int getIsdisabled() {
		return isdisabled;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}