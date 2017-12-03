package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.Member;
import com.report.manage.bean.Menu;
import com.report.manage.bean.User;

public interface LoginDao {

    public User selectUserInfo(User user) throws BaseException;

    public Member selectMember(Member member) throws BaseException;

    public List<Menu> selectMenuList(int userid) throws BaseException;

    public List<Menu> selectSubMenuList(int userid, int pid)
            throws BaseException;
}