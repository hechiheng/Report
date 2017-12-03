package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.global.SysGlobals;
import com.report.home.bean.Message;
import com.report.manage.dao.iface.MessageDao;

public class MessageBo {
    private DaoManager daoManager;

    private MessageDao dao;

    Logger logger = Logger.getLogger(MessageBo.class);

    public MessageBo() throws BaseException {
        this.daoManager = DaoConfig.getDaoManager();
        this.dao = (MessageDao) daoManager.getDao(MessageDao.class);
    }

    public int getMessageListSize(Message message) throws BaseException {
        return dao.selectMessageListSize(message);
    }

    public List<Message> getMessageList(Message message) throws BaseException {
        return dao.selectMessageList(message);
    }

    public Message getMessage(int id) throws BaseException {
        return dao.selectMessage(id);
    }

    public void addMessage(Message message) throws BaseException {
        dao.insertMessage(message);
    }

    public void modifyMessage(Message message) throws BaseException {
        dao.updateMessage(message);
    }

    public void modifyMessageIsvalid(Message message) throws BaseException {
        dao.updateMessageIsvalid(message);
    }

    public void removeMessage(int id) throws BaseException {
        dao.deleteMessage(id);
    }

    public List<Message> getLatestMessageList() throws BaseException {
        int listRows = Integer.valueOf(SysGlobals
                .getSysConfig("index_page_size"));
        return dao.selectLatestMessageList(listRows);
    }

}