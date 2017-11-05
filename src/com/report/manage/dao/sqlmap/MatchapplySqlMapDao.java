package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
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
	public List<Matchapply> selectMatchapplyList(Matchapply matchapply)
			throws BaseException {
		try {
			return this.queryForList(
					"manage.MatchapplyDao.selectMatchapplyList", matchapply);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.selectMatchapplyList", e);
			throw new BaseException(
					"manage.MatchapplyDao.selectMatchapplyList", e);
		}
	}

	public int selectMatchapplyList1Size(Matchapply matchapply)
			throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.MatchapplyDao.selectMatchapplyList1Size",
					matchapply);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.selectMatchapplyList1Size", e);
			throw new BaseException(
					"manage.MatchapplyDao.selectMatchapplyList1Size", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Matchapply> selectMatchapplyList1(Matchapply matchapply)
			throws BaseException {
		try {
			return this.queryForList(
					"manage.MatchapplyDao.selectMatchapplyList1", matchapply);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.selectMatchapplyList1", e);
			throw new BaseException(
					"manage.MatchapplyDao.selectMatchapplyList1", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Matchinfo> selectMatchinfoList() throws BaseException {
		try {
			return this.queryForList(
					"manage.MatchapplyDao.selectMatchinfoList", null);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.selectMatchinfoList", e);
			throw new BaseException("manage.MatchapplyDao.selectMatchinfoList",
					e);
		}
	}

	public void deleteMatchapply(int id) throws BaseException {
		try {
			this.delete("manage.MatchapplyDao.deleteMatchapply", id);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.deleteMatchapply", e);
			throw new BaseException("manage.MatchapplyDao.deleteMatchapply", e);
		}
	}

	public void insertMatchapply(Matchapply matchapply) throws BaseException {
		try {
			this.insert("manage.MatchapplyDao.insertMatchapply", matchapply);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.insertMatchapply", e);
			throw new BaseException("manage.MatchapplyDao.insertMatchapply", e);
		}
	}

	public Matchapply selectMatchapply(int id) throws BaseException {
		try {
			return (Matchapply) this.queryForObject(
					"manage.MatchapplyDao.selectMatchapply", id);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.selectMatchapply", e);
			throw new BaseException("manage.MatchapplyDao.selectMatchapply", e);
		}
	}

	public void updateMatchapply(Matchapply matchapply) throws BaseException {
		try {
			this.update("manage.MatchapplyDao.updateMatchapply", matchapply);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.updateMatchapply", e);
			throw new BaseException("manage.MatchapplyDao.updateMatchapply", e);
		}
	}

	public void updateMatchapplyState(Matchapply matchapply)
			throws BaseException {
		try {
			this.update("manage.MatchapplyDao.updateMatchapplyState",
					matchapply);
		} catch (DaoException e) {
			logger.error("manage.MatchapplyDao.updateMatchapplyState", e);
			throw new BaseException(
					"manage.MatchapplyDao.updateMatchapplyState", e);
		}
	}

}