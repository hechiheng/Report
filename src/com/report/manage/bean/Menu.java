package com.report.manage.bean;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private int pid;

	private int isleaf;

	private int isshow;

	private int sort;
	private String url;
	private List<Menu> subMenuList;

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

	public int getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
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

}