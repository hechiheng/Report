package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Member;
import com.report.manage.dao.iface.MemberDao;

public class MemberSqlMapDao extends SqlMapDaoTemplate implements MemberDao {

	Logger logger = Logger.getLogger("MemberSqlMapDao");

	public MemberSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectMemberListSize(Member member) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.MemberDao.selectMemberListSize", member);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.selectMemberListSize", e);
			throw new BaseException("manage.MemberDao.selectMemberListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Member> selectMemberList(Member member) throws BaseException {
		try {
			return this.queryForList("manage.MemberDao.selectMemberList",
					member);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.selectMemberList", e);
			throw new BaseException("manage.MemberDao.selectMemberList", e);
		}
	}

	public void updateMemberIsvalid(Member member) throws BaseException {
		try {
			this.update("manage.MemberDao.updateMemberIsvalid", member);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.updateMemberIsvalid", e);
			throw new BaseException("manage.MemberDao.updateMemberIsvalid", e);
		}
	}

	public void deleteMember(int id) throws BaseException {
		try {
			this.delete("manage.MemberDao.deleteMember", id);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.deleteMember", e);
			throw new BaseException("manage.MemberDao.deleteMember", e);
		}
	}

	public void insertMember(Member member) throws BaseException {
		try {
			this.insert("manage.MemberDao.insertMember", member);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.insertMember", e);
			throw new BaseException("manage.MemberDao.insertMember", e);
		}
	}

	public Member selectMember(int id) throws BaseException {
		try {
			return (Member) this.queryForObject(
					"manage.MemberDao.selectMember", id);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.selectMember", e);
			throw new BaseException("manage.MemberDao.selectMember", e);
		}
	}

	public void updateMember(Member member) throws BaseException {
		try {
			this.update("manage.MemberDao.updateMember", member);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.updateMember", e);
			throw new BaseException("manage.MemberDao.updateMember", e);
		}
	}

	public void updateMemberPwd(Member member) throws BaseException {
		try {
			this.update("manage.MemberDao.updateMemberPwd", member);
		} catch (DaoException e) {
			logger.error("manage.MemberDao.updateMemberPwd", e);
			throw new BaseException("manage.MemberDao.updateMemberPwd", e);
		}
	}

}