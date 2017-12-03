package com.report.manage.bo;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.bean.Member;
import com.report.manage.bean.Menu;
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
        return dao.selectUserInfo(user);
    }

    public Member getMemberInfo(Member member) throws BaseException {
        member.setPassword(DigestUtils.md5Hex(member.getPassword()));
        return dao.selectMember(member);
    }

    public List<Menu> getMenuList(int userid) throws BaseException {
        List<Menu> menuList = dao.selectMenuList(userid);
        for (Menu menu : menuList) {
            List<Menu> subMenuList = dao
                    .selectSubMenuList(userid, menu.getId());
            menu.setSubMenuList(subMenuList);
        }
        return menuList;
    }
}