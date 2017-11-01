package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.Matchinfo;
import com.report.manage.bean.Matchtype;
import com.report.manage.dao.iface.MatchinfoDao;

public class MatchinfoSqlMapDao extends SqlMapDaoTemplate implements
		MatchinfoDao {

	Logger logger = Logger.getLogger("MatchinfoSqlMapDao");

	public MatchinfoSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectMatchinfoListSize(Matchinfo matchinfo)
			throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.MatchinfoDao.selectMatchinfoListSize", matchinfo);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.selectMatchinfoListSize", e);
			throw new BaseException(
					"manage.MatchinfoDao.selectMatchinfoListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Matchinfo> selectMatchinfoList(Matchinfo matchinfo)
			throws BaseException {
		try {
			return this.queryForList("manage.MatchinfoDao.selectMatchinfoList",
					matchinfo);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.selectMatchinfoList", e);
			throw new BaseException("manage.MatchinfoDao.selectMatchinfoList",
					e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Matchtype> selectMatchtypeList() throws BaseException {
		try {
			return this.queryForList("manage.MatchinfoDao.selectMatchtypeList",
					null);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.selectMatchtypeList", e);
			throw new BaseException("manage.MatchinfoDao.selectMatchtypeList",
					e);
		}
	}

	public void updateMatchinfoIsvalid(Matchinfo matchinfo)
			throws BaseException {
		try {
			this
					.update("manage.MatchinfoDao.updateMatchinfoIsvalid",
							matchinfo);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.updateMatchinfoIsvalid", e);
			throw new BaseException(
					"manage.MatchinfoDao.updateMatchinfoIsvalid", e);
		}
	}

	public void deleteMatchinfo(int id) throws BaseException {
		try {
			this.delete("manage.MatchinfoDao.deleteMatchinfo", id);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.deleteMatchinfo", e);
			throw new BaseException("manage.MatchinfoDao.deleteMatchinfo", e);
		}
	}

	public void insertMatchinfo(Matchinfo matchinfo) throws BaseException {
		try {
			this.insert("manage.MatchinfoDao.insertMatchinfo", matchinfo);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.insertMatchinfo", e);
			throw new BaseException("manage.MatchinfoDao.insertMatchinfo", e);
		}
	}

	public Matchinfo selectMatchinfo(int id) throws BaseException {
		try {
			return (Matchinfo) this.queryForObject(
					"manage.MatchinfoDao.selectMatchinfo", id);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.selectMatchinfo", e);
			throw new BaseException("manage.MatchinfoDao.selectMatchinfo", e);
		}
	}

	public void updateMatchinfo(Matchinfo matchinfo) throws BaseException {
		try {
			this.update("manage.MatchinfoDao.updateMatchinfo", matchinfo);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.updateMatchinfo", e);
			throw new BaseException("manage.MatchinfoDao.updateMatchinfo", e);
		}
	}

	public void updateMatchinfoIsdisabled(Matchinfo matchinfo)
			throws BaseException {
		try {
			this.update("manage.MatchinfoDao.updateMatchinfoIsdisabled",
					matchinfo);
		} catch (DaoException e) {
			logger.error("manage.MatchinfoDao.updateMatchinfoIsdisabled", e);
			throw new BaseException(
					"manage.MatchinfoDao.updateMatchinfoIsdisabled", e);
		}
	}

}