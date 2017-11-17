package com.report.manage.bean;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String description;
	private int isvalid;
	private int isdisabled;
	private String updatetime;
	private int menuid;
	private int roletype;
	private String menuids;
	private int firstRow;
	private int listRows;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setIsdisabled(int isdisabled) {
		this.isdisabled = isdisabled;
	}

	public int getIsdisabled() {
		return isdisabled;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getListRows() {
		return listRows;
	}

	public void setListRows(int listRows) {
		this.listRows = listRows;
	}

	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}

	public String getMenuids() {
		return menuids;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setRoletype(int roletype) {
		this.roletype = roletype;
	}

	public int getRoletype() {
		return roletype;
	}

}