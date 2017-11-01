package com.report.manage.dao.sqlmap;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Notice;
import com.report.manage.dao.iface.NoticeDao;

public class NoticeSqlMapDao extends SqlMapDaoTemplate implements NoticeDao {

	Logger logger = Logger.getLogger("NoticeSqlMapDao");

	public NoticeSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public Notice selectNotice() throws BaseException {
		try {
			return (Notice) this.queryForObject(
					"manage.NoticeDao.selectNotice", null);
		} catch (DaoException e) {
			logger.error("manage.NoticeDao.selectNotice", e);
			throw new BaseException("manage.NoticeDao.selectNotice", e);
		}
	}

	public void insertNotice(Notice notice) throws BaseException {
		try {
			this.insert("manage.NoticeDao.insertNotice", notice);
		} catch (DaoException e) {
			logger.error("manage.NoticeDao.insertNotice", e);
			throw new BaseException("manage.NoticeDao.insertNotice", e);
		}
	}

	public void updateNotice(Notice notice) throws BaseException {
		try {
			this.update("manage.NoticeDao.updateNotice", notice);
		} catch (DaoException e) {
			logger.error("manage.NoticeDao.updateNotice", e);
			throw new BaseException("manage.NoticeDao.updateNotice", e);
		}
	}

}