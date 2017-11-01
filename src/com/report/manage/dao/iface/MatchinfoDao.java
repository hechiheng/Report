package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.manage.bean.Matchinfo;
import com.report.manage.bean.Matchtype;

public interface MatchinfoDao {

	public int selectMatchinfoListSize(Matchinfo matchinfo)
			throws BaseException;

	public List<Matchinfo> selectMatchinfoList(Matchinfo matchinfo)
			throws BaseException;

	public Matchinfo selectMatchinfo(int id) throws BaseException;

	public List<Matchtype> selectMatchtypeList() throws BaseException;

	public void insertMatchinfo(Matchinfo matchinfo) throws BaseException;

	public void updateMatchinfo(Matchinfo matchinfo) throws BaseException;

	public void updateMatchinfoIsvalid(Matchinfo matchinfo)
			throws BaseException;

	public void deleteMatchinfo(int id) throws BaseException;

	public void updateMatchinfoIsdisabled(Matchinfo matchinfo)
			throws BaseException;

}