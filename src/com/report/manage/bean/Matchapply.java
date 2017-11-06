package com.report.manage.bean;

import java.io.Serializable;

public class Matchapply implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private int matchid;

    private String matchname;

    private String orgcode;

    private String name;

    private String annualmatch;

    private String unitname;

    private String authors;

    private String teachers;

    private String description;

    private int isvalid;

    private int state;

    private String begindate;

    private String enddate;

    private String updatetime;

    private String checktime;

    private int memberid;

    private int checkuserid;

    private String imagecode;

    private int firstRow;

    private int listRows;

    private int score;

    private String ranking;

    private String awards;

    private int ispublish;

    private int matchresultid;

    private int resultuserid;

    private String publishtime;

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

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnualmatch() {
        return annualmatch;
    }

    public void setAnnualmatch(String annualmatch) {
        this.annualmatch = annualmatch;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public int getCheckuserid() {
        return checkuserid;
    }

    public void setCheckuserid(int checkuserid) {
        this.checkuserid = checkuserid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }

    public int getMatchid() {
        return matchid;
    }

    public void setImagecode(String imagecode) {
        this.imagecode = imagecode;
    }

    public String getImagecode() {
        return imagecode;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public int getIspublish() {
        return ispublish;
    }

    public void setIspublish(int ispublish) {
        this.ispublish = ispublish;
    }

    public void setMatchresultid(int matchresultid) {
        this.matchresultid = matchresultid;
    }

    public int getMatchresultid() {
        return matchresultid;
    }

    public void setResultuserid(int resultuserid) {
        this.resultuserid = resultuserid;
    }

    public int getResultuserid() {
        return resultuserid;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getPublishtime() {
        return publishtime;
    }

}