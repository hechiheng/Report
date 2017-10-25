package com.report.home.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;
import com.report.home.dao.iface.HomeDao;

public class HomeBo {
	private DaoManager daoManager;

	private HomeDao dao;

	Logger logger = Logger.getLogger(HomeBo.class);

	public HomeBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (HomeDao) daoManager.getDao(HomeDao.class);
	}

	public Announce getLatestAnnounce() throws BaseException {
		return dao.getLatestAnnounce();
	}

	public List<Message> getLatestMessageList() throws BaseException {
		return dao.getLatestMessageList();
	}

	public List<News> getLatestNewsList() throws BaseException {
		return dao.getLatestNewsList();
	}

	public List<Link> getLinkList() throws BaseException {
		return dao.getLinkList();
	}

	public int getMessageListSize() throws BaseException {
		return dao.getMessageListSize();
	}

	public List<Message> getMessageList(Message message) throws BaseException {
		return dao.getMessageList(message);
	}

	public Message getMessage(int id) throws BaseException {
		return dao.getMessage(id);
	}
}