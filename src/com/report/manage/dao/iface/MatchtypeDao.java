package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.manage.bean.Matchtype;

public interface MatchtypeDao {

	public List<Matchtype> selectMatchtypeList(Matchtype matchtype)
			throws BaseException;

	public void updateMatchtypeIsvalid(Matchtype matchtype)
			throws BaseException;

	public void deleteMatchtype(int id) throws BaseException;

	public void insertMatchtype(Matchtype matchtype) throws BaseException;

	public Matchtype selectMatchtype(int id) throws BaseException;

	public void updateMatchtype(Matchtype matchtype) throws BaseException;

	public void updateMatchtypeIsdisabled(Matchtype matchtype)
			throws BaseException;

}