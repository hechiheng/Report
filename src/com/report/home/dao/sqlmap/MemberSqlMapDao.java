package com.report.home.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.dao.iface.MemberDao;
import com.report.manage.bean.Member;

public class MemberSqlMapDao extends SqlMapDaoTemplate implements MemberDao {

	Logger logger = Logger.getLogger("HomeSqlMapDao");

	public MemberSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int getMemberCount(String accountid) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"home.MemberDao.getMemberCount", accountid);
		} catch (DaoException e) {
			logger.error("home.MemberDao.getMemberCount", e);
			throw new BaseException("home.MemberDao.getMemberCount", e);
		}
	}

	public void insertMember(Member member) throws BaseException {
		try {
			this.insert("home.MemberDao.insertMember", member);
		} catch (DaoException e) {
			logger.error("home.MemberDao.insertMember", e);
			throw new BaseException("home.MemberDao.insertMember", e);
		}
	}

	public Member getMember(int id) throws BaseException {
		try {
			return (Member) this.queryForObject("home.MemberDao.getMember", id);
		} catch (DaoException e) {
			logger.error("home.MemberDao.getMember", e);
			throw new BaseException("home.MemberDao.getMember", e);
		}
	}

}