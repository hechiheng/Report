package com.report.home.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.About;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;
import com.report.home.dao.iface.HomeDao;

public class HomeSqlMapDao extends SqlMapDaoTemplate implements HomeDao {

	Logger logger = Logger.getLogger("HomeSqlMapDao");

	public HomeSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public Announce selectLatestAnnounce() throws BaseException {
		try {
			return (Announce) this.queryForObject(
					"home.HomeDao.selectLatestAnnounce", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectLatestAnnounce", e);
			throw new BaseException("home.HomeDao.selectLatestAnnounce", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Message> selectLatestMessageList() throws BaseException {
		try {
			return this.queryForList("home.HomeDao.selectLatestMessageList",
					null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectLatestMessageList", e);
			throw new BaseException("home.HomeDao.selectLatestMessageList", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<News> selectLatestNewsList() throws BaseException {
		try {
			return this.queryForList("home.HomeDao.selectLatestNewsList", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectLatestNewsList", e);
			throw new BaseException("home.HomeDao.selectLatestNewsList", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Link> selectLinkList() throws BaseException {
		try {
			return this.queryForList("home.HomeDao.selectLinkList", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectLinkList", e);
			throw new BaseException("home.HomeDao.selectLinkList", e);
		}
	}

	public int selectMessageListSize() throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"home.HomeDao.selectMessageListSize", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectMessageListSize", e);
			throw new BaseException("home.HomeDao.selectMessageListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Message> selectMessageList(Message message)
			throws BaseException {
		try {
			return this.queryForList("home.HomeDao.selectMessageList", message);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectMessageList", e);
			throw new BaseException("home.HomeDao.selectMessageList", e);
		}
	}

	public Message selectMessage(int id) throws BaseException {
		try {
			return (Message) this.queryForObject("home.HomeDao.selectMessage",
					id);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectMessage", e);
			throw new BaseException("home.HomeDao.selectMessage", e);
		}
	}

	public int selectNewsListSize() throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"home.HomeDao.selectNewsListSize", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectNewsListSize", e);
			throw new BaseException("home.HomeDao.selectNewsListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<News> selectNewsList(News news) throws BaseException {
		try {
			return this.queryForList("home.HomeDao.selectNewsList", news);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectNewsList", e);
			throw new BaseException("home.HomeDao.selectNewsList", e);
		}
	}

	public News selectNews(int id) throws BaseException {
		try {
			return (News) this.queryForObject("home.HomeDao.selectNews", id);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectNews", e);
			throw new BaseException("home.HomeDao.selectNews", e);
		}
	}

	public About selectAbout() throws BaseException {
		try {
			return (About) this
					.queryForObject("home.HomeDao.selectAbout", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.selectAbout", e);
			throw new BaseException("home.HomeDao.selectAbout", e);
		}
	}

}