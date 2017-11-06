package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;
import com.report.manage.dao.iface.MatchapplyDao;

public class MatchapplyBo {
    private DaoManager daoManager;

    private MatchapplyDao dao;

    Logger logger = Logger.getLogger(MatchapplyBo.class);

    public MatchapplyBo() throws BaseException {
        this.daoManager = DaoConfig.getDaoManager();
        this.dao = (MatchapplyDao) daoManager.getDao(MatchapplyDao.class);
    }

    public List<Matchapply> getMatchapplyList(Matchapply matchapply)
            throws BaseException {
        return dao.selectMatchapplyList(matchapply);
    }

    public List<Matchapply> getMatchresultList(Matchapply matchapply)
            throws BaseException {
        return dao.selectMatchresultList(matchapply);
    }

    public int getMatchapplyList1Size(Matchapply matchapply)
            throws BaseException {
        return dao.selectMatchapplyList1Size(matchapply);
    }

    public List<Matchapply> getMatchapplyList1(Matchapply matchapply)
            throws BaseException {
        return dao.selectMatchapplyList1(matchapply);
    }

    public Matchapply getMatchapply(int id) throws BaseException {
        return dao.selectMatchapply(id);
    }

    public List<Matchinfo> getMatchinfoList() throws BaseException {
        return dao.selectMatchinfoList();
    }

    public void addMatchapply(Matchapply matchapply) throws BaseException {
        dao.insertMatchapply(matchapply);
    }

    public void modifyMatchapply(Matchapply matchapply) throws BaseException {
        dao.updateMatchapply(matchapply);
    }

    public void removeMatchapply(int id) throws BaseException {
        dao.deleteMatchapply(id);
    }

    public void auditMatchapply(Matchapply matchapply) throws BaseException {
        dao.updateMatchapplyState(matchapply);
    }

    public int getMatchresultCount(Matchapply matchapply) throws BaseException {
        return dao.selectMatchresultCount(matchapply);
    }

    public void addMatchresult(Matchapply matchapply) throws BaseException {
        dao.insertMatchresult(matchapply);
    }

    public void modifyMatchresult(Matchapply matchapply) throws BaseException {
        dao.updateMatchresult(matchapply);
    }

}