package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Message;
import com.report.manage.dao.iface.MessageDao;

public class MessageSqlMapDao extends SqlMapDaoTemplate implements MessageDao {

	Logger logger = Logger.getLogger("MessageSqlMapDao");

	public MessageSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectMessageListSize(Message message) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.MessageDao.selectMessageListSize", message);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.selectMessageListSize", e);
			throw new BaseException("manage.MessageDao.selectMessageListSize",
					e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Message> selectMessageList(Message message)
			throws BaseException {
		try {
			return this.queryForList("manage.MessageDao.selectMessageList",
					message);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.selectMessageList", e);
			throw new BaseException("manage.MessageDao.selectMessageList", e);
		}
	}

	public Message selectMessage(int id) throws BaseException {
		try {
			return (Message) this.queryForObject(
					"manage.MessageDao.selectMessage", id);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.selectMessage", e);
			throw new BaseException("manage.MessageDao.selectMessage", e);
		}
	}

	public void insertMessage(Message message) throws BaseException {
		try {
			this.insert("manage.MessageDao.insertMessage", message);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.insertMessage", e);
			throw new BaseException("manage.MessageDao.insertMessage", e);
		}
	}

	public void updateMessage(Message message) throws BaseException {
		try {
			this.update("manage.MessageDao.updateMessage", message);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.updateMessage", e);
			throw new BaseException("manage.MessageDao.updateMessage", e);
		}
	}

	public void updateMessageIsvalid(Message message) throws BaseException {
		try {
			this.update("manage.MessageDao.updateMessageIsvalid", message);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.updateMessageIsvalid", e);
			throw new BaseException("manage.MessageDao.updateMessageIsvalid", e);
		}
	}

	public void deleteMessage(int id) throws BaseException {
		try {
			this.delete("manage.MessageDao.deleteMessage", id);
		} catch (DaoException e) {
			logger.error("manage.MessageDao.deleteMessage", e);
			throw new BaseException("manage.MessageDao.deleteMessage", e);
		}
	}

}