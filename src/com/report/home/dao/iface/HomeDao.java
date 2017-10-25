package com.report.home.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;

public interface HomeDao {

	public Announce getLatestAnnounce() throws BaseException;

	public List<Message> getLatestMessageList() throws BaseException;

	public List<News> getLatestNewsList() throws BaseException;

	public List<Link> getLinkList() throws BaseException;

	public int getMessageListSize() throws BaseException;

	public List<Message> getMessageList(Message message) throws BaseException;

	public Message getMessage(int id) throws BaseException;
}