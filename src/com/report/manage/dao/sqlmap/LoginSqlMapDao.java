package com.report.manage.dao.sqlmap;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Member;
import com.report.manage.bean.Menu;
import com.report.manage.bean.User;
import com.report.manage.dao.iface.LoginDao;

public class LoginSqlMapDao extends SqlMapDaoTemplate implements LoginDao {

    Logger logger = Logger.getLogger("LoginSqlMapDao");

    public LoginSqlMapDao(DaoManager arg0) {
        super(arg0);
    }

    public User selectUserInfo(User user) throws BaseException {
        try {
            return (User) this.queryForObject("manage.LoginDao.selectUserInfo",
                    user);
        }
        catch (DaoException e) {
            logger.error("manage.LoginDao.selectUserInfo", e);
            throw new BaseException("manage.LoginDao.selectUserInfo", e);
        }
    }

    public Member selectMember(Member member) throws BaseException {
        try {
            return (Member) this.queryForObject("manage.LoginDao.selectMember",
                    member);
        }
        catch (DaoException e) {
            logger.error("manage.LoginDao.selectMember", e);
            throw new BaseException("manage.LoginDao.selectMember", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Menu> selectMenuList(int userid) throws BaseException {
        try {
            return this.queryForList("manage.LoginDao.selectMenuList", userid);
        }
        catch (DaoException e) {
            logger.error("manage.LoginDao.selectMenuList", e);
            throw new BaseException("manage.LoginDao.selectMenuList", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Menu> selectSubMenuList(int userid, int pid)
            throws BaseException {
        try {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("userid", userid);
            map.put("pid", pid);
            return this.queryForList("manage.LoginDao.selectSubMenuList", map);
        }
        catch (DaoException e) {
            logger.error("manage.LoginDao.selectSubMenuList", e);
            throw new BaseException("manage.LoginDao.selectSubMenuList", e);
        }
    }

}