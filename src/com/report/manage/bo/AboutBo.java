package com.report.manage.bo;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.bean.About;
import com.report.manage.dao.iface.AboutDao;

public class AboutBo {
    private DaoManager daoManager;

    private AboutDao dao;

    Logger logger = Logger.getLogger(AboutBo.class);

    public AboutBo() throws BaseException {
        this.daoManager = DaoConfig.getDaoManager();
        this.dao = (AboutDao) daoManager.getDao(AboutDao.class);
    }

    public About getAbout(int id) throws BaseException {
        return dao.selectAbout(id);
    }

    public void modifyAbout(About about) throws BaseException {
        dao.updateAbout(about);
    }

}