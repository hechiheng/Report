package com.report.manage.bo;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Website;
import com.report.manage.dao.iface.WebsiteDao;

public class WebsiteBo {
	private DaoManager daoManager;

	private WebsiteDao dao;

	Logger logger = Logger.getLogger(WebsiteBo.class);

	public WebsiteBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (WebsiteDao) daoManager.getDao(WebsiteDao.class);
	}

	public Website getWebsite() throws BaseException {
		return dao.selectWebsite();
	}

	public void modifyWebsite(Website website) throws BaseException {
		dao.updateWebsite(website);
	}

}