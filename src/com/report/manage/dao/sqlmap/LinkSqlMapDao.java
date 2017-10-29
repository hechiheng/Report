package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.home.bean.Link;
import com.report.manage.dao.iface.LinkDao;

public class LinkSqlMapDao extends SqlMapDaoTemplate implements LinkDao {

	Logger logger = Logger.getLogger("LinkSqlMapDao");

	public LinkSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	@SuppressWarnings("unchecked")
	public List<Link> selectLinkList(Link link) throws BaseException {
		try {
			return this.queryForList("manage.LinkDao.selectLinkList", link);
		} catch (DaoException e) {
			logger.error("manage.LinkDao.selectLinkList", e);
			throw new BaseException("manage.LinkDao.selectLinkList", e);
		}
	}

	public Link selectLink(int id) throws BaseException {
		try {
			return (Link) this.queryForObject("manage.LinkDao.selectLink", id);
		} catch (DaoException e) {
			logger.error("manage.LinkDao.selectLink", e);
			throw new BaseException("manage.LinkDao.selectLink", e);
		}
	}

	public void insertLink(Link link) throws BaseException {
		try {
			this.insert("manage.LinkDao.insertLink", link);
		} catch (DaoException e) {
			logger.error("manage.LinkDao.insertLink", e);
			throw new BaseException("manage.LinkDao.insertLink", e);
		}
	}

	public void updateLink(Link link) throws BaseException {
		try {
			this.update("manage.LinkDao.updateLink", link);
		} catch (DaoException e) {
			logger.error("manage.LinkDao.updateLink", e);
			throw new BaseException("manage.LinkDao.updateLink", e);
		}
	}

	public void updateLinkIsvalid(Link link) throws BaseException {
		try {
			this.update("manage.LinkDao.updateLinkIsvalid", link);
		} catch (DaoException e) {
			logger.error("manage.LinkDao.updateLinkIsvalid", e);
			throw new BaseException("manage.LinkDao.updateLinkIsvalid", e);
		}
	}

	public void deleteLink(int id) throws BaseException {
		try {
			this.delete("manage.LinkDao.deleteLink", id);
		} catch (DaoException e) {
			logger.error("manage.LinkDao.deleteLink", e);
			throw new BaseException("manage.LinkDao.deleteLink", e);
		}
	}

}