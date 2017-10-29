package com.report.home.bean;

import java.io.Serializable;

public class Announce implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String content;
	private String starttime;
	private String endtime;
	private int isvalid;
	private String publishtime;
	private int ispublish;
	private int isexpire;
	private String updatetime;
	private int userid;
	private int firstRow;
	private int listRows;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
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

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public int getIspublish() {
		return ispublish;
	}

	public void setIspublish(int ispublish) {
		this.ispublish = ispublish;
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

	public void setIsexpire(int isexpire) {
		this.isexpire = isexpire;
	}

	public int getIsexpire() {
		return isexpire;
	}

}
