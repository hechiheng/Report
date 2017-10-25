package com.report.manage.bean;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private String nickname;

    private String regtime;

    private String updatetime;

    private String logintime;

    private String loginip;

    private String loginnum;

    private String isvalid;

    private String islock;

    /**
     * id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(String id) {
        this.id = id;
    }

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
     * nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * regtime
     */
    public String getRegtime() {
        return regtime;
    }

    /**
     * regtime
     */
    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    /**
     * updatetime
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * updatetime
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * logintime
     */
    public String getLogintime() {
        return logintime;
    }

    /**
     * logintime
     */
    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    /**
     * loginip
     */
    public String getLoginip() {
        return loginip;
    }

    /**
     * loginip
     */
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    /**
     * loginnum
     */
    public String getLoginnum() {
        return loginnum;
    }

    /**
     * loginnum
     */
    public void setLoginnum(String loginnum) {
        this.loginnum = loginnum;
    }

    /**
     * isvalid
     */
    public String getIsvalid() {
        return isvalid;
    }

    /**
     * isvalid
     */
    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    /**
     * islock
     */
    public String getIslock() {
        return islock;
    }

    /**
     * islock
     */
    public void setIslock(String islock) {
        this.islock = islock;
    }
}