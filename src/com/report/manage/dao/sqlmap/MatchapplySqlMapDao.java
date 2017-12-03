package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Member;
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;
import com.report.manage.dao.iface.MatchapplyDao;

public class MatchapplySqlMapDao extends SqlMapDaoTemplate implements
        MatchapplyDao {

    Logger logger = Logger.getLogger("MatchapplySqlMapDao");

    public MatchapplySqlMapDao(DaoManager arg0) {
        super(arg0);
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchapplyList4Home(Matchapply matchapply)
            throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchapplyList4Home",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyList4Home", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyList4Home", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchresultList4Home(Matchapply matchapply)
            throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchresultList4Home",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchresultList4Home", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchresultList4Home", e);
        }
    }

    public int selectMatchapplyAuditListSize(Matchapply matchapply)
            throws BaseException {
        try {
            return (Integer) this.queryForObject(
                    "manage.MatchapplyDao.selectMatchapplyAuditListSize",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyAuditListSize",
                    e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyAuditListSize", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchapplyAuditList(Matchapply matchapply)
            throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchapplyAuditList",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyAuditList", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyAuditList", e);
        }
    }

    public int selectMatchapplyAuditList1Size(Matchapply matchapply)
            throws BaseException {
        try {
            return (Integer) this.queryForObject(
                    "manage.MatchapplyDao.selectMatchapplyAuditList1Size",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyAuditList1Size",
                    e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyAuditList1Size", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchapplyAuditList1(Matchapply matchapply)
            throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchapplyAuditList",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyAuditList", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyAuditList", e);
        }
    }

    public int selectMatchresultListSize(Matchapply matchapply)
            throws BaseException {
        try {
            return (Integer) this.queryForObject(
                    "manage.MatchapplyDao.selectMatchresultListSize",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchresultListSize", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchresultListSize", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchresultList(Matchapply matchapply)
            throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchresultList", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchresultList", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchresultList", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchinfo> selectMatchinfoList() throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchinfoList", null);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchinfoList", e);
            throw new BaseException("manage.MatchapplyDao.selectMatchinfoList",
                    e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Member> selectMemberList() throws BaseException {
        try {
            return this.queryForList("manage.MatchapplyDao.selectMemberList",
                    null);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMemberList", e);
            throw new BaseException("manage.MatchapplyDao.selectMemberList", e);
        }
    }

    public void deleteMatchapply(int id) throws BaseException {
        try {
            this.delete("manage.MatchapplyDao.deleteMatchapply", id);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.deleteMatchapply", e);
            throw new BaseException("manage.MatchapplyDao.deleteMatchapply", e);
        }
    }

    public void insertMatchapply(Matchapply matchapply) throws BaseException {
        try {
            this.insert("manage.MatchapplyDao.insertMatchapply", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.insertMatchapply", e);
            throw new BaseException("manage.MatchapplyDao.insertMatchapply", e);
        }
    }

    public Matchapply selectMatchapply(int id) throws BaseException {
        try {
            return (Matchapply) this.queryForObject(
                    "manage.MatchapplyDao.selectMatchapply", id);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapply", e);
            throw new BaseException("manage.MatchapplyDao.selectMatchapply", e);
        }
    }

    public void updateMatchapply(Matchapply matchapply) throws BaseException {
        try {
            this.update("manage.MatchapplyDao.updateMatchapply", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.updateMatchapply", e);
            throw new BaseException("manage.MatchapplyDao.updateMatchapply", e);
        }
    }

    public void updateMatchapplyState(Matchapply matchapply)
            throws BaseException {
        try {
            this.update("manage.MatchapplyDao.updateMatchapplyState",
                    matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.updateMatchapplyState", e);
            throw new BaseException(
                    "manage.MatchapplyDao.updateMatchapplyState", e);
        }
    }

    public int selectMatchresultCount(Matchapply matchapply)
            throws BaseException {
        try {
            return (Integer) this.queryForObject(
                    "manage.MatchapplyDao.selectMatchresultCount", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchresultCount", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchresultCount", e);
        }
    }

    public void insertMatchresult(Matchapply matchapply) throws BaseException {
        try {
            this.insert("manage.MatchapplyDao.insertMatchresult", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.insertMatchresult", e);
            throw new BaseException("manage.MatchapplyDao.insertMatchresult", e);
        }
    }

    public void updateMatchresult(Matchapply matchapply) throws BaseException {
        try {
            this.update("manage.MatchapplyDao.updateMatchresult", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.updateMatchresult", e);
            throw new BaseException("manage.MatchapplyDao.updateMatchresult", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchapplyFileList(Matchapply matchapply)
            throws BaseException {
        try {
            return this
                    .queryForList(
                            "manage.MatchapplyDao.selectMatchapplyFileList",
                            matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyFileList", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyFileList", e);
        }
    }

    public int selectMatchapplyListSize(Matchapply matchapply)
            throws BaseException {
        try {
            return (Integer) this
                    .queryForObject(
                            "manage.MatchapplyDao.selectMatchapplyListSize",
                            matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyListSize", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyListSize", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Matchapply> selectMatchapplyList(Matchapply matchapply)
            throws BaseException {
        try {
            return this.queryForList(
                    "manage.MatchapplyDao.selectMatchapplyList", matchapply);
        }
        catch (DaoException e) {
            logger.error("manage.MatchapplyDao.selectMatchapplyList", e);
            throw new BaseException(
                    "manage.MatchapplyDao.selectMatchapplyList", e);
        }
    }

}