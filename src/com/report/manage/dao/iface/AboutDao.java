package com.report.manage.dao.iface;

import com.css.base.BaseException;
import com.report.home.bean.About;

public interface AboutDao {

	public About selectAbout() throws BaseException;

	public void insertAbout(About about) throws BaseException;

	public void updateAbout(About about) throws BaseException;

}