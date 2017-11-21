package com.report.manage.dao.iface;

import com.css.base.BaseException;
import com.report.home.bean.About;

public interface AboutDao {

    public About selectAbout(int id) throws BaseException;

    public void updateAbout(About about) throws BaseException;

}