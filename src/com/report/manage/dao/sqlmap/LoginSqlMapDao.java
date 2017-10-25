package com.report.manage.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.User;
import com.report.manage.dao.iface.LoginDao;

public class LoginSqlMapDao extends SqlMapDaoTemplate implements LoginDao {

    Logger logger = Logger.getLogger("LoginSqlMapDao");

    public LoginSqlMapDao(DaoManager arg0) {
        super(arg0);
    }

    public User getUserInfo(User user) throws BaseException {
        try {
            return (User) this.queryForObject("manage.getUserInfo", user);
        }
        catch (DaoException e) {
            logger.error("manage.getUserInfo", e);
            throw new BaseException("LoginSqlMapDao.getUserInfo", e);
        }
    }

}