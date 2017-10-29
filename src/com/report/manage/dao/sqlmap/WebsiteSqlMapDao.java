package com.report.manage.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.Website;
import com.report.manage.dao.iface.WebsiteDao;

public class WebsiteSqlMapDao extends SqlMapDaoTemplate implements WebsiteDao {

	Logger logger = Logger.getLogger("WebsiteSqlMapDao");

	public WebsiteSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public Website selectWebsite() throws BaseException {
		try {
			return (Website) this.queryForObject(
					"manage.WebsiteDao.selectWebsite", null);
		} catch (DaoException e) {
			logger.error("manage.WebsiteDao.selectWebsite", e);
			throw new BaseException("manage.WebsiteDao.selectWebsite", e);
		}
	}

	public void updateWebsite(Website website) throws BaseException {
		try {
			this.update("manage.WebsiteDao.updateWebsite", website);
		} catch (DaoException e) {
			logger.error("manage.WebsiteDao.updateWebsite", e);
			throw new BaseException("manage.WebsiteDao.updateWebsite", e);
		}
	}

}