package com.report.home.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.global.SysGlobals;
import com.report.home.bean.About;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;
import com.report.home.bean.Notice;
import com.report.home.dao.iface.HomeDao;
import com.report.manage.bean.Website;

public class HomeBo {
    private DaoManager daoManager;

    private HomeDao dao;

    Logger logger = Logger.getLogger(HomeBo.class);

    public HomeBo() throws BaseException {
        this.daoManager = DaoConfig.getDaoManager();
        this.dao = (HomeDao) daoManager.getDao(HomeDao.class);
    }

    public Announce getLatestAnnounce() throws BaseException {
        return dao.selectLatestAnnounce();
    }

    public List<Message> getLatestMessageList() throws BaseException {
        int listRows = Integer.valueOf(SysGlobals
                .getSysConfig("index_page_size"));
        return dao.selectLatestMessageList(listRows);
    }

    public List<News> getLatestNewsList() throws BaseException {
        int listRows = Integer.valueOf(SysGlobals
                .getSysConfig("index_page_size"));
        return dao.selectLatestNewsList(listRows);
    }

    public List<Link> getLinkList() throws BaseException {
        return dao.selectLinkList();
    }

    public int getMessageListSize() throws BaseException {
        return dao.selectMessageListSize();
    }

    public List<Message> getMessageList(Message message) throws BaseException {
        return dao.selectMessageList(message);
    }

    public Message getMessage(int id) throws BaseException {
        return dao.selectMessage(id);
    }

    public int getNewsListSize() throws BaseException {
        return dao.selectNewsListSize();
    }

    public List<News> getNewsList(News news) throws BaseException {
        return dao.selectNewsList(news);
    }

    public News getNews(int id) throws BaseException {
        return dao.selectNews(id);
    }

    public About getAbout(int id) throws BaseException {
        return dao.selectAbout(id);
    }

    public Announce getAnnounce(int id) throws BaseException {
        return dao.selectAnnounce(id);
    }

    public Notice getNotice() throws BaseException {
        return dao.selectNotice();
    }

    public Website getWebsite() throws BaseException {
        return dao.selectWebsite();
    }
}