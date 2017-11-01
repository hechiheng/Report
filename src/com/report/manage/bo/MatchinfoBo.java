package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Matchinfo;
import com.report.manage.bean.Matchtype;
import com.report.manage.dao.iface.MatchinfoDao;

public class MatchinfoBo {
	private DaoManager daoManager;

	private MatchinfoDao dao;

	Logger logger = Logger.getLogger(MatchinfoBo.class);

	public MatchinfoBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MatchinfoDao) daoManager.getDao(MatchinfoDao.class);
	}

	public int getMatchinfoListSize(Matchinfo matchinfo) throws BaseException {
		return dao.selectMatchinfoListSize(matchinfo);
	}

	public List<Matchinfo> getMatchinfoList(Matchinfo matchinfo)
			throws BaseException {
		return dao.selectMatchinfoList(matchinfo);
	}

	public Matchinfo getMatchinfo(int id) throws BaseException {
		return dao.selectMatchinfo(id);
	}

	public List<Matchtype> getMatchtypeList() throws BaseException {
		return dao.selectMatchtypeList();
	}

	public void addMatchinfo(Matchinfo matchinfo) throws BaseException {
		dao.insertMatchinfo(matchinfo);
	}

	public void modifyMatchinfo(Matchinfo matchinfo) throws BaseException {
		dao.updateMatchinfo(matchinfo);
	}

	public void modifyMatchinfoIsvalid(Matchinfo matchinfo)
			throws BaseException {
		dao.updateMatchinfoIsvalid(matchinfo);
	}

	public void removeMatchinfo(int id) throws BaseException {
		dao.deleteMatchinfo(id);
	}

	public void disabledMatchinfo(Matchinfo matchinfo) throws BaseException {
		dao.updateMatchinfoIsdisabled(matchinfo);
	}

}