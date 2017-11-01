package com.report.home.dao.iface;

import com.css.base.BaseException;
import com.report.home.bean.Member;

public interface LoginDao {

	public Member selectMember(Member member) throws BaseException;

	public void updateMemberLogintime(Member member) throws BaseException;
}