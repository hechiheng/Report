package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.manage.bean.Menu;

public interface MenuDao {

	public List<Menu> selectTopMenuList(Menu menu) throws BaseException;

	public List<Menu> selectSubMenuList(Menu menu) throws BaseException;

	public Menu selectMenu(int id) throws BaseException;

	public void insertMenu(Menu menu) throws BaseException;

	public void updateMenu(Menu menu) throws BaseException;

	public void updateMenuIsvalid(Menu menu) throws BaseException;

	public void deleteMenu(int id) throws BaseException;

}