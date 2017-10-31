package com.report.manage.bean;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String keyword;
	private int pid;
	private int isshow;
	private int sort;
	private int isvalid;
	private String url;
	private String updatetime;
	private List<Menu> subMenuList;
	private int roleid;
	private int menuid;

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getMenuid() {
		return menuid;
	}

}