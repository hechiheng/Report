package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.home.bean.Link;
import com.report.manage.dao.iface.LinkDao;

public class LinkBo {
	private DaoManager daoManager;

	private LinkDao dao;

	Logger logger = Logger.getLogger(LinkBo.class);

	public LinkBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (LinkDao) daoManager.getDao(LinkDao.class);
	}

	public List<Link> getLinkList(Link link) throws BaseException {
		return dao.selectLinkList(link);
	}

	public Link getLink(int id) throws BaseException {
		return dao.selectLink(id);
	}

	public void addLink(Link link) throws BaseException {
		dao.insertLink(link);
	}

	public void modifyLink(Link link) throws BaseException {
		dao.updateLink(link);
	}

	public void modifyLinkIsvalid(Link link) throws BaseException {
		dao.updateLinkIsvalid(link);
	}

	public void removeLink(int id) throws BaseException {
		dao.deleteLink(id);
	}

}