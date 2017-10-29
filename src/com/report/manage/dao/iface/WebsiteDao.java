package com.report.manage.dao.iface;

import com.css.base.BaseException;
import com.report.manage.bean.Website;

public interface WebsiteDao {

	public Website selectWebsite() throws BaseException;

	public void updateWebsite(Website website) throws BaseException;

}