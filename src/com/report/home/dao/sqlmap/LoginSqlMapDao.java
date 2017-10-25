package com.report.home.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.dao.iface.LoginDao;
import com.report.manage.bean.Member;

public class LoginSqlMapDao extends SqlMapDaoTemplate implements LoginDao {

	Logger logger = Logger.getLogger("LoginSqlMapDao");

	public LoginSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public Member getMember(Member member) throws BaseException {
		try {
			return (Member) this.queryForObject("home.LoginDao.getMember",
					member);
		} catch (DaoException e) {
			logger.error("home.LoginDao.getMember", e);
			throw new BaseException("home.LoginDao.getMember", e);
		}
	}

}