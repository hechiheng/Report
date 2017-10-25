package com.report.manage.bo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.User;
import com.report.manage.dao.iface.LoginDao;

public class LoginBo {
    private DaoManager daoManager;

    private LoginDao dao;

    Logger logger = Logger.getLogger(LoginBo.class);

    public LoginBo() throws BaseException {
        this.daoManager = DaoConfig.getDaoManager();
        this.dao = (LoginDao) daoManager.getDao(LoginDao.class);
    }

    public User getUserInfo(User user) throws BaseException {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return dao.getUserInfo(user);
    }
}