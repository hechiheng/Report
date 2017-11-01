package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.Matchtype;
import com.report.manage.dao.iface.MatchtypeDao;

public class MatchtypeSqlMapDao extends SqlMapDaoTemplate implements
		MatchtypeDao {

	Logger logger = Logger.getLogger("MatchtypeSqlMapDao");

	public MatchtypeSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	@SuppressWarnings("unchecked")
	public List<Matchtype> selectMatchtypeList(Matchtype matchtype)
			throws BaseException {
		try {
			return this.queryForList("manage.MatchtypeDao.selectMatchtypeList",
					matchtype);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.selectMatchtypeList", e);
			throw new BaseException("manage.MatchtypeDao.selectMatchtypeList",
					e);
		}
	}

	public void updateMatchtypeIsvalid(Matchtype matchtype)
			throws BaseException {
		try {
			this
					.update("manage.MatchtypeDao.updateMatchtypeIsvalid",
							matchtype);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.updateMatchtypeIsvalid", e);
			throw new BaseException(
					"manage.MatchtypeDao.updateMatchtypeIsvalid", e);
		}
	}

	public void deleteMatchtype(int id) throws BaseException {
		try {
			this.delete("manage.MatchtypeDao.deleteMatchtype", id);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.deleteMatchtype", e);
			throw new BaseException("manage.MatchtypeDao.deleteMatchtype", e);
		}
	}

	public void insertMatchtype(Matchtype matchtype) throws BaseException {
		try {
			this.insert("manage.MatchtypeDao.insertMatchtype", matchtype);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.insertMatchtype", e);
			throw new BaseException("manage.MatchtypeDao.insertMatchtype", e);
		}
	}

	public Matchtype selectMatchtype(int id) throws BaseException {
		try {
			return (Matchtype) this.queryForObject(
					"manage.MatchtypeDao.selectMatchtype", id);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.selectMatchtype", e);
			throw new BaseException("manage.MatchtypeDao.selectMatchtype", e);
		}
	}

	public void updateMatchtype(Matchtype matchtype) throws BaseException {
		try {
			this.update("manage.MatchtypeDao.updateMatchtype", matchtype);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.updateMatchtype", e);
			throw new BaseException("manage.MatchtypeDao.updateMatchtype", e);
		}
	}

	public void updateMatchtypeIsdisabled(Matchtype matchtype)
			throws BaseException {
		try {
			this.update("manage.MatchtypeDao.updateMatchtypeIsdisabled",
					matchtype);
		} catch (DaoException e) {
			logger.error("manage.MatchtypeDao.updateMatchtypeIsdisabled", e);
			throw new BaseException(
					"manage.MatchtypeDao.updateMatchtypeIsdisabled", e);
		}
	}

}