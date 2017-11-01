package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Matchtype;
import com.report.manage.dao.iface.MatchtypeDao;

public class MatchtypeBo {
	private DaoManager daoManager;

	private MatchtypeDao dao;

	Logger logger = Logger.getLogger(MatchtypeBo.class);

	public MatchtypeBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MatchtypeDao) daoManager.getDao(MatchtypeDao.class);
	}

	public List<Matchtype> getMatchtypeList(Matchtype matchtype)
			throws BaseException {
		return dao.selectMatchtypeList(matchtype);
	}

	public Matchtype getMatchtype(int id) throws BaseException {
		return dao.selectMatchtype(id);
	}

	public void addMatchtype(Matchtype matchtype) throws BaseException {
		dao.insertMatchtype(matchtype);
	}

	public void modifyMatchtype(Matchtype matchtype) throws BaseException {
		dao.updateMatchtype(matchtype);
	}

	public void modifyMatchtypeIsvalid(Matchtype matchtype)
			throws BaseException {
		dao.updateMatchtypeIsvalid(matchtype);
	}

	public void removeMatchtype(int id) throws BaseException {
		dao.deleteMatchtype(id);
	}

	public void disabledMatchtype(Matchtype matchtype) throws BaseException {
		dao.updateMatchtypeIsdisabled(matchtype);
	}

}