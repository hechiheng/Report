package com.report.manage.bo;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.bean.Notice;
import com.report.manage.dao.iface.NoticeDao;

public class NoticeBo {
	private DaoManager daoManager;

	private NoticeDao dao;

	Logger logger = Logger.getLogger(NoticeBo.class);

	public NoticeBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (NoticeDao) daoManager.getDao(NoticeDao.class);
	}

	public Notice getNotice() throws BaseException {
		return dao.selectNotice();
	}

	public void addNotice(Notice notice) throws BaseException {
		if (getNotice() == null) {
			dao.insertNotice(notice);
		} else {
			dao.updateNotice(notice);
		}
	}

	public void modifyNotice(Notice notice) throws BaseException {
		dao.updateNotice(notice);
	}

}