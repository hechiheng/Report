package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.home.bean.Link;

public interface LinkDao {

	public List<Link> selectLinkList(Link link) throws BaseException;

	public Link selectLink(int id) throws BaseException;

	public void insertLink(Link link) throws BaseException;

	public void updateLink(Link link) throws BaseException;

	public void updateLinkIsvalid(Link link) throws BaseException;

	public void deleteLink(int id) throws BaseException;

}