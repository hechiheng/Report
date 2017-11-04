package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;
import com.report.manage.dao.iface.MatchapplyDao;

public class MatchapplyBo {
	private DaoManager daoManager;

	private MatchapplyDao dao;

	Logger logger = Logger.getLogger(MatchapplyBo.class);

	public MatchapplyBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MatchapplyDao) daoManager.getDao(MatchapplyDao.class);
	}

	public List<Matchapply> getMatchapplyList(Matchapply matchinfo)
			throws BaseException {
		return dao.selectMatchapplyList(matchinfo);
	}

	public Matchapply getMatchapply(int id) throws BaseException {
		return dao.selectMatchapply(id);
	}

	public List<Matchinfo> getMatchinfoList() throws BaseException {
		return dao.selectMatchinfoList();
	}

	public void addMatchapply(Matchapply matchinfo) throws BaseException {
		dao.insertMatchapply(matchinfo);
	}

	public void modifyMatchapply(Matchapply matchinfo) throws BaseException {
		dao.updateMatchapply(matchinfo);
	}

	public void removeMatchapply(int id) throws BaseException {
		dao.deleteMatchapply(id);
	}

}