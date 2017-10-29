package com.report.home.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.About;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;

public interface HomeDao {

	public Announce selectLatestAnnounce() throws BaseException;

	public List<Message> selectLatestMessageList() throws BaseException;

	public List<News> selectLatestNewsList() throws BaseException;

	public List<Link> selectLinkList() throws BaseException;

	public int selectMessageListSize() throws BaseException;

	public List<Message> selectMessageList(Message message)
			throws BaseException;

	public Message selectMessage(int id) throws BaseException;

	public int selectNewsListSize() throws BaseException;

	public List<News> selectNewsList(News news) throws BaseException;

	public News selectNews(int id) throws BaseException;

	public Announce selectAnnounce(int id) throws BaseException;

	public About selectAbout() throws BaseException;
}