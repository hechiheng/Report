package com.report.manage.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.About;
import com.report.manage.dao.iface.AboutDao;

public class AboutSqlMapDao extends SqlMapDaoTemplate implements AboutDao {

	Logger logger = Logger.getLogger("AboutSqlMapDao");

	public AboutSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public About selectAbout() throws BaseException {
		try {
			return (About) this.queryForObject("manage.AboutDao.selectAbout",
					null);
		} catch (DaoException e) {
			logger.error("manage.AboutDao.selectAbout", e);
			throw new BaseException("manage.AboutDao.selectAbout", e);
		}
	}

	public void insertAbout(About about) throws BaseException {
		try {
			this.insert("manage.AboutDao.insertAbout", about);
		} catch (DaoException e) {
			logger.error("manage.AboutDao.insertAbout", e);
			throw new BaseException("manage.AboutDao.insertAbout", e);
		}
	}

	public void updateAbout(About about) throws BaseException {
		try {
			this.update("manage.AboutDao.updateAbout", about);
		} catch (DaoException e) {
			logger.error("manage.AboutDao.updateAbout", e);
			throw new BaseException("manage.AboutDao.updateAbout", e);
		}
	}

}