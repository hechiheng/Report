package com.report.manage.bo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.Constants;
import com.report.global.DaoConfig;
import com.report.home.bean.Member;
import com.report.manage.dao.iface.MemberDao;

public class MemberBo {
	private DaoManager daoManager;

	private MemberDao dao;

	Logger logger = Logger.getLogger(MemberBo.class);

	public MemberBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MemberDao) daoManager.getDao(MemberDao.class);
	}

	public int getMemberListSize(Member member) throws BaseException {
		return dao.selectMemberListSize(member);
	}

	public List<Member> getMemberList(Member member) throws BaseException {
		return dao.selectMemberList(member);
	}

	public int getMemberCount(String accountid) throws BaseException {
		return dao.selectMemberCount(accountid);
	}

	public Member getMember(int id) throws BaseException {
		return dao.selectMember(id);
	}

	public String verifyMember(String accountid) throws BaseException {
		String key = "";
		if (dao.selectMemberCount(accountid) > 0) {
			key = "member.exist";
		} else if (!this.verify(accountid)) {
			key = "member.invalid";
		}
		return key;

	}

	public boolean verify(String accountid) {
		Pattern p = Pattern.compile("^[0-9a-zA-Z]*$");
		Matcher m = p.matcher(accountid);
		return m.matches();
	}

	public void addMember(Member member) throws BaseException {
		member.setPassword(DigestUtils.md5Hex(member.getPassword()));
		dao.insertMember(member);
	}

	public void modifyMember(Member member) throws BaseException {
		dao.updateMember(member);
	}

	public void modifyMemberIsvalid(Member member) throws BaseException {
		dao.updateMemberIsvalid(member);
	}

	public void resetMemberPwd(Member member) throws BaseException {
		member.setPassword(DigestUtils.md5Hex(Constants.DEFAULT_PWD));
		dao.updateMemberPwd(member);
	}

	public void removeMember(int id) throws BaseException {
		dao.deleteMember(id);
	}

	public void lockMember(Member member) throws BaseException {
		dao.updateMemberIslock(member);
	}

}