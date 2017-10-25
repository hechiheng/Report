package com.report.home.dao.iface;

import com.css.base.BaseException;

public interface MemberDao {

	public int getMemberCount(String accountid) throws BaseException;

}