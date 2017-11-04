package com.report.manage.bean;

import java.io.Serializable;

public class Matchinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int matchtype;
	private String matchtypename;
	private String orgcode;
	private String name;
	private String annualmatch;
	private String optunitname;
	private String description;
	private String content;
	private int isvalid;
	private String begindate;
	private String enddate;
	private String updatetime;
	private int userid;
	private int firstRow;
	private int listRows;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getMatchtype() {
		return matchtype;
	}

	public void setMatchtype(int matchtype) {
		this.matchtype = matchtype;
	}

	public String getAnnualmatch() {
		return annualmatch;
	}

	public void setAnnualmatch(String annualmatch) {
		this.annualmatch = annualmatch;
	}

	public String getOptunitname() {
		return optunitname;
	}

	public void setOptunitname(String optunitname) {
		this.optunitname = optunitname;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public void setMatchtypename(String matchtypename) {
		this.matchtypename = matchtypename;
	}

	public String getMatchtypename() {
		return matchtypename;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
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

}