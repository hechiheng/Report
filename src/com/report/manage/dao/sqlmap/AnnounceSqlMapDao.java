package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Announce;
import com.report.manage.dao.iface.AnnounceDao;

public class AnnounceSqlMapDao extends SqlMapDaoTemplate implements AnnounceDao {

	Logger logger = Logger.getLogger("AnnounceSqlMapDao");

	public AnnounceSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectAnnounceListSize(Announce announce) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.AnnounceDao.selectAnnounceListSize", announce);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.selectAnnounceListSize", e);
			throw new BaseException(
					"manage.AnnounceDao.selectAnnounceListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Announce> selectAnnounceList(Announce announce)
			throws BaseException {
		try {
			return this.queryForList("manage.AnnounceDao.selectAnnounceList",
					announce);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.selectAnnounceList", e);
			throw new BaseException("manage.AnnounceDao.selectAnnounceList", e);
		}
	}

	public Announce selectAnnounce(int id) throws BaseException {
		try {
			return (Announce) this.queryForObject(
					"manage.AnnounceDao.selectAnnounce", id);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.selectAnnounce", e);
			throw new BaseException("manage.AnnounceDao.selectAnnounce", e);
		}
	}

	public void insertAnnounce(Announce announce) throws BaseException {
		try {
			this.insert("manage.AnnounceDao.insertAnnounce", announce);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.insertAnnounce", e);
			throw new BaseException("manage.AnnounceDao.insertAnnounce", e);
		}
	}

	public void updateAnnounce(Announce announce) throws BaseException {
		try {
			this.update("manage.AnnounceDao.updateAnnounce", announce);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.updateAnnounce", e);
			throw new BaseException("manage.AnnounceDao.updateAnnounce", e);
		}
	}

	public void updateAnnounceIsvalid(Announce announce) throws BaseException {
		try {
			this.update("manage.AnnounceDao.updateAnnounceIsvalid", announce);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.updateAnnounceIsvalid", e);
			throw new BaseException("manage.AnnounceDao.updateAnnounceIsvalid",
					e);
		}
	}

	public void updateAnnounceUnpublish(int id) throws BaseException {
		try {
			this.update("manage.AnnounceDao.updateAnnounceUnpublish", id);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.updateAnnounceUnpublish", e);
			throw new BaseException(
					"manage.AnnounceDao.updateAnnounceUnpublish", e);
		}
	}
	
	public void updateAnnouncePublish(Announce announce) throws BaseException {
		try {
			this.update("manage.AnnounceDao.updateAnnouncePublish", announce);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.updateAnnouncePublish", e);
			throw new BaseException(
					"manage.AnnounceDao.updateAnnouncePublish", e);
		}
	}

	public void deleteAnnounce(int id) throws BaseException {
		try {
			this.delete("manage.AnnounceDao.deleteAnnounce", id);
		} catch (DaoException e) {
			logger.error("manage.AnnounceDao.deleteAnnounce", e);
			throw new BaseException("manage.AnnounceDao.deleteAnnounce", e);
		}
	}

}