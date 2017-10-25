package com.report.home.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
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

	public Announce getLatestAnnounce() throws BaseException {
		try {
			return (Announce) this.queryForObject(
					"home.HomeDao.getLatestAnnounce", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getLatestAnnounce", e);
			throw new BaseException("home.HomeDao.getLatestAnnounce", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Message> getLatestMessageList() throws BaseException {
		try {
			return this.queryForList("home.HomeDao.getLatestMessageList", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getLatestMessageList", e);
			throw new BaseException("home.HomeDao.getLatestMessageList", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<News> getLatestNewsList() throws BaseException {
		try {
			return this.queryForList("home.HomeDao.getLatestNewsList", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getLatestNewsList", e);
			throw new BaseException("home.HomeDao.getLatestNewsList", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Link> getLinkList() throws BaseException {
		try {
			return this.queryForList("home.HomeDao.getLinkList", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getLinkList", e);
			throw new BaseException("home.HomeDao.getLinkList", e);
		}
	}

	public int getMessageListSize() throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"home.HomeDao.getMessageListSize", null);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getMessageListSize", e);
			throw new BaseException("home.HomeDao.getMessageListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessageList(Message message) throws BaseException {
		try {
			return this.queryForList("home.HomeDao.getMessageList", message);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getMessageList", e);
			throw new BaseException("home.HomeDao.getMessageList", e);
		}
	}

	public Message getMessage(int id) throws BaseException {
		try {
			return (Message) this.queryForObject("home.HomeDao.getMessage", id);
		} catch (DaoException e) {
			logger.error("home.HomeDao.getMessage", e);
			throw new BaseException("home.HomeDao.getMessage", e);
		}
	}

}