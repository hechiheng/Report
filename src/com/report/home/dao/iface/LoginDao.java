package com.report.home.dao.iface;

import com.css.base.BaseException;
import com.report.manage.bean.Member;

public interface LoginDao {

	public Member getMember(Member member) throws BaseException;
}