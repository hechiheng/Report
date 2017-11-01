package com.report.manage.dao.iface;

import com.css.base.BaseException;
import com.report.home.bean.Notice;

public interface NoticeDao {

	public Notice selectNotice() throws BaseException;

	public void insertNotice(Notice notice) throws BaseException;

	public void updateNotice(Notice notice) throws BaseException;

}