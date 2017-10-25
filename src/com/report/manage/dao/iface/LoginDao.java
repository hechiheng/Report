package com.report.manage.dao.iface;

import com.css.base.BaseException;
import com.report.manage.bean.User;

public interface LoginDao {

    public User getUserInfo(User user) throws BaseException;
}