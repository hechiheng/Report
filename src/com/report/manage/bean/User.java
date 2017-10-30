package com.report.manage.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String password_re;
	private String password_old;
	private String factname;
	private int sex;
	private String qq;
	private String email;
	private String tel;
	private int usertype;
	private int roleid;
	private String rolename;
	private String regtime;
	private String logintime;
	private int isvalid;
	private int islock;
	private int firstRow;
	private int listRows;

	/**
	 * username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * email
	 */
	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getPassword_re() {
		return password_re;
	}

	public void setPassword_re(String passwordRe) {
		password_re = passwordRe;
	}

	public String getPassword_old() {
		return password_old;
	}

	public void setPassword_old(String passwordOld) {
		password_old = passwordOld;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public int getIslock() {
		return islock;
	}

	public void setIslock(int islock) {
		this.islock = islock;
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

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setFactname(String factname) {
		this.factname = factname;
	}

	public String getFactname() {
		return factname;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

}