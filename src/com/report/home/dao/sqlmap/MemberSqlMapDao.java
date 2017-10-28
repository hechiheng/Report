package com.report.home.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Member;
import com.report.home.dao.iface.MemberDao;

public class MemberSqlMapDao extends SqlMapDaoTemplate implements MemberDao {

	Logger logger = Logger.getLogger("HomeSqlMapDao");

	public MemberSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectMemberCount(String accountid) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"home.MemberDao.selectMemberCount", accountid);
		} catch (DaoException e) {
			logger.error("home.MemberDao.selectMemberCount", e);
			throw new BaseException("home.MemberDao.selectMemberCount", e);
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

	public Member selectMember(int id) throws BaseException {
		try {
			return (Member) this.queryForObject("home.MemberDao.selectMember",
					id);
		} catch (DaoException e) {
			logger.error("home.MemberDao.selectMember", e);
			throw new BaseException("home.MemberDao.selectMember", e);
		}
	}

	public void updateMember(Member member) throws BaseException {
		try {
			this.update("home.MemberDao.updateMember", member);
		} catch (DaoException e) {
			logger.error("home.MemberDao.updateMember", e);
			throw new BaseException("home.MemberDao.updateMember", e);
		}
	}

	public void updateMemberPwd(Member member) throws BaseException {
		try {
			this.update("home.MemberDao.updateMemberPwd", member);
		} catch (DaoException e) {
			logger.error("home.MemberDao.updateMemberPwd", e);
			throw new BaseException("home.MemberDao.updateMemberPwd", e);
		}
	}

}