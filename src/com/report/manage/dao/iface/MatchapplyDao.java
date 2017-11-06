package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;

public interface MatchapplyDao {

    public List<Matchapply> selectMatchapplyList(Matchapply matchapply)
            throws BaseException;

    public List<Matchapply> selectMatchresultList(Matchapply matchapply)
            throws BaseException;

    public int selectMatchapplyList1Size(Matchapply matchapply)
            throws BaseException;

    public List<Matchapply> selectMatchapplyList1(Matchapply matchapply)
            throws BaseException;

    public Matchapply selectMatchapply(int id) throws BaseException;

    public List<Matchinfo> selectMatchinfoList() throws BaseException;

    public void insertMatchapply(Matchapply matchapply) throws BaseException;

    public void updateMatchapply(Matchapply matchapply) throws BaseException;

    public void deleteMatchapply(int id) throws BaseException;

    public void updateMatchapplyState(Matchapply matchapply)
            throws BaseException;

    public int selectMatchresultCount(Matchapply matchapply)
            throws BaseException;

    public void insertMatchresult(Matchapply matchapply) throws BaseException;

    public void updateMatchresult(Matchapply matchapply) throws BaseException;

}