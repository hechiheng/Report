package com.report.home.dao.iface;

import com.css.base.BaseException;
import com.report.manage.bean.Member;

public interface MemberDao {

	public int getMemberCount(String accountid) throws BaseException;

	public void insertMember(Member member) throws BaseException;

}