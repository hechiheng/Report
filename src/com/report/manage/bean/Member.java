package com.report.manage.bean;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String accountid;
	private String password;
	private String password_re;
	private String factname;
	private String sex;
	private String idcard;
	private String birthday;
	private String address;
	private String qq;
	private String email;
	private String tel;
	private String regtime;
	private String isvalid;
	private String imagecode;
	private int firstRow;
	private int listRows;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFactname() {
		return factname;
	}

	public void setFactname(String factname) {
		this.factname = factname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
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

	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}

	public String getImagecode() {
		return imagecode;
	}

	public void setPassword_re(String password_re) {
		this.password_re = password_re;
	}

	public String getPassword_re() {
		return password_re;
	}

}