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
			return this.queryForList("home.MatchapplyDao.selectMatchapplyList",
					matchapply);
		} catch (DaoException e) {
			logger.error("home.MatchapplyDao.selectMatchapplyList", e);
			throw new BaseException("home.MatchapplyDao.selectMatchapplyList",
					e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Matchinfo> selectMatchinfoList() throws BaseException {
		try {
			return this.queryForList("home.MatchapplyDao.selectMatchinfoList",
					null);
		} catch (DaoException e) {
			logger.error("home.MatchapplyDao.selectMatchinfoList", e);
			throw new BaseException("home.MatchapplyDao.selectMatchinfoList", e);
		}
	}

	public void deleteMatchapply(int id) throws BaseException {
		try {
			this.delete("home.MatchapplyDao.deleteMatchapply", id);
		} catch (DaoException e) {
			logger.error("home.MatchapplyDao.deleteMatchapply", e);
			throw new BaseException("home.MatchapplyDao.deleteMatchapply", e);
		}
	}

	public void insertMatchapply(Matchapply matchapply) throws BaseException {
		try {
			this.insert("home.MatchapplyDao.insertMatchapply", matchapply);
		} catch (DaoException e) {
			logger.error("home.MatchapplyDao.insertMatchapply", e);
			throw new BaseException("home.MatchapplyDao.insertMatchapply", e);
		}
	}

	public Matchapply selectMatchapply(int id) throws BaseException {
		try {
			return (Matchapply) this.queryForObject(
					"home.MatchapplyDao.selectMatchapply", id);
		} catch (DaoException e) {
			logger.error("home.MatchapplyDao.selectMatchapply", e);
			throw new BaseException("home.MatchapplyDao.selectMatchapply", e);
		}
	}

	public void updateMatchapply(Matchapply matchapply) throws BaseException {
		try {
			this.update("home.MatchapplyDao.updateMatchapply", matchapply);
		} catch (DaoException e) {
			logger.error("home.MatchapplyDao.updateMatchapply", e);
			throw new BaseException("home.MatchapplyDao.updateMatchapply", e);
		}
	}

}