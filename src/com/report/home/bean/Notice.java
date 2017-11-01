package com.report.home.bean;

import java.io.Serializable;

public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String content;
	private String updatetime;
	private int userid;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getUserid() {
		return userid;
	}

}
