package com.report.home.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Member;
import com.report.home.dao.iface.LoginDao;

public class LoginSqlMapDao extends SqlMapDaoTemplate implements LoginDao {

	Logger logger = Logger.getLogger("LoginSqlMapDao");

	public LoginSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public Member selectMember(Member member) throws BaseException {
		try {
			return (Member) this.queryForObject("home.LoginDao.selectMember",
					member);
		} catch (DaoException e) {
			logger.error("home.LoginDao.selectMember", e);
			throw new BaseException("home.LoginDao.selectMember", e);
		}
	}

	public void updateMemberLogintime(Member member) throws BaseException {
		try {
			this.update("home.MemberDao.updateMemberLogintime", member);
		} catch (DaoException e) {
			logger.error("home.MemberDao.updateMemberLogintime", e);
			throw new BaseException("home.MemberDao.updateMemberLogintime", e);
		}
	}

}