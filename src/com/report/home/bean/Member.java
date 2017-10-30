package com.report.home.bean;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String accountid;
	private String password;
	private String password_re;
	private String password_old;
	private String factname;
	private int sex;
	private String idcard;
	private String birthday;
	private String address;
	private String qq;
	private String email;
	private String tel;
	private String regtime;
	private String logintime;
	private String updatetime;
	private int isvalid;
	private int islock;
	private String imagecode;
	private int firstRow;
	private int listRows;

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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setPassword_old(String password_old) {
		this.password_old = password_old;
	}

	public String getPassword_old() {
		return password_old;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getIslock() {
		return islock;
	}

	public void setIslock(int islock) {
		this.islock = islock;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

}