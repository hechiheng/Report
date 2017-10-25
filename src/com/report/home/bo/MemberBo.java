package com.report.home.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.dao.iface.MemberDao;

public class MemberBo {
	private DaoManager daoManager;

	private MemberDao dao;

	Logger logger = Logger.getLogger(MemberBo.class);

	public MemberBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MemberDao) daoManager.getDao(MemberDao.class);
	}

	public String verifyMember(String accountid) throws BaseException {
		String key = "";
		if (dao.getMemberCount(accountid) > 0) {
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

}