package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.News;
import com.report.manage.dao.iface.NewsDao;

public class NewsSqlMapDao extends SqlMapDaoTemplate implements NewsDao {

	Logger logger = Logger.getLogger("NewsSqlMapDao");

	public NewsSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectNewsListSize(News news) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.NewsDao.selectNewsListSize", news);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.selectNewsListSize", e);
			throw new BaseException("manage.NewsDao.selectNewsListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<News> selectNewsList(News news) throws BaseException {
		try {
			return this.queryForList("manage.NewsDao.selectNewsList", news);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.selectNewsList", e);
			throw new BaseException("manage.NewsDao.selectNewsList", e);
		}
	}

	public News selectNews(int id) throws BaseException {
		try {
			return (News) this.queryForObject("manage.NewsDao.selectNews", id);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.selectNews", e);
			throw new BaseException("manage.NewsDao.selectNews", e);
		}
	}

	public void insertNews(News news) throws BaseException {
		try {
			this.insert("manage.NewsDao.insertNews", news);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.insertNews", e);
			throw new BaseException("manage.NewsDao.insertNews", e);
		}
	}

	public void updateNews(News news) throws BaseException {
		try {
			this.update("manage.NewsDao.updateNews", news);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.updateNews", e);
			throw new BaseException("manage.NewsDao.updateNews", e);
		}
	}

	public void updateNewsIsvalid(News news) throws BaseException {
		try {
			this.update("manage.NewsDao.updateNewsIsvalid", news);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.updateNewsIsvalid", e);
			throw new BaseException("manage.NewsDao.updateNewsIsvalid", e);
		}
	}

	public void deleteNews(int id) throws BaseException {
		try {
			this.delete("manage.NewsDao.deleteNews", id);
		} catch (DaoException e) {
			logger.error("manage.NewsDao.deleteNews", e);
			throw new BaseException("manage.NewsDao.deleteNews", e);
		}
	}

}