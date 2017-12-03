package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.Message;

public interface MessageDao {

    public int selectMessageListSize(Message message) throws BaseException;

    public List<Message> selectMessageList(Message message)
            throws BaseException;

    public Message selectMessage(int id) throws BaseException;

    public void insertMessage(Message message) throws BaseException;

    public void updateMessage(Message message) throws BaseException;

    public void updateMessageIsvalid(Message message) throws BaseException;

    public void deleteMessage(int id) throws BaseException;

    public List<Message> selectLatestMessageList(int listRows)
            throws BaseException;

}