package com.report.home.bo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.dao.iface.LoginDao;
import com.report.manage.bean.Member;

public class LoginBo {
	private DaoManager daoManager;

	private LoginDao dao;

	Logger logger = Logger.getLogger(LoginBo.class);

	public LoginBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (LoginDao) daoManager.getDao(LoginDao.class);
	}

	public Member getMember(Member member) throws BaseException {
		member.setPassword(DigestUtils.md5Hex(member.getPassword()));
		return dao.getMember(member);
	}
}