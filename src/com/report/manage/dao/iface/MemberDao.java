package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.Member;

public interface MemberDao {

	public int selectMemberListSize(Member member) throws BaseException;

	public List<Member> selectMemberList(Member member) throws BaseException;

	public int selectMemberCount(String accountid) throws BaseException;

	public void updateMemberIsvalid(Member member) throws BaseException;

	public void deleteMember(int id) throws BaseException;

	public void insertMember(Member member) throws BaseException;

	public Member selectMember(int id) throws BaseException;

	public void updateMember(Member member) throws BaseException;

	public void updateMemberPwd(Member member) throws BaseException;
	
	public void updateMemberIslock(Member member) throws BaseException;

}