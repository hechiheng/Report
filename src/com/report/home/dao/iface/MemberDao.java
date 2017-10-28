package com.report.home.dao.iface;

import com.css.base.BaseException;
import com.report.home.bean.Member;

public interface MemberDao {

	public int selectMemberCount(String accountid) throws BaseException;

	public void insertMember(Member member) throws BaseException;

	public Member selectMember(int id) throws BaseException;

	public void updateMember(Member member) throws BaseException;

	public void updateMemberPwd(Member member) throws BaseException;

}