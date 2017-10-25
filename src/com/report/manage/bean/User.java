package com.report.manage.bean;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private String realname;

    private String email;

    private String usertype;

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
     * realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * realname
     */
    public String getRealname() {
        return realname;
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

    /**
     * usertype
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * usertype
     */
    public String getUsertype() {
        return usertype;
    }

}