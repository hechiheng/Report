package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.News;

public interface NewsDao {

	public int selectNewsListSize(News news) throws BaseException;

	public List<News> selectNewsList(News news) throws BaseException;

	public News selectNews(int id) throws BaseException;

	public void insertNews(News news) throws BaseException;

	public void updateNews(News news) throws BaseException;

	public void updateNewsIsvalid(News news) throws BaseException;

	public void deleteNews(int id) throws BaseException;

}