package com.report.home.bean;

import java.io.Serializable;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String color;
	private String author;
	private String keywords;
	private String content;
	private String description;
	private String isvalid;
	private String publishtime;
	private String ispublish;
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

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getIspublish() {
		return ispublish;
	}

	public void setIspublish(String ispublish) {
		this.ispublish = ispublish;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setListRows(int listRows) {
		this.listRows = listRows;
	}

	public int getListRows() {
		return listRows;
	}

}
