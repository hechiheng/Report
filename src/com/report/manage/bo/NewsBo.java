package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.bean.News;
import com.report.manage.dao.iface.NewsDao;

public class NewsBo {
	private DaoManager daoManager;

	private NewsDao dao;

	Logger logger = Logger.getLogger(NewsBo.class);

	public NewsBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (NewsDao) daoManager.getDao(NewsDao.class);
	}

	public int getNewsListSize(News news) throws BaseException {
		return dao.selectNewsListSize(news);
	}

	public List<News> getNewsList(News news) throws BaseException {
		return dao.selectNewsList(news);
	}

	public News getNews(int id) throws BaseException {
		return dao.selectNews(id);
	}

	public void addNews(News news) throws BaseException {
		dao.insertNews(news);
	}

	public void modifyNews(News news) throws BaseException {
		dao.updateNews(news);
	}

	public void modifyNewsIsvalid(News news) throws BaseException {
		dao.updateNewsIsvalid(news);
	}

	public void removeNews(int id) throws BaseException {
		dao.deleteNews(id);
	}

}