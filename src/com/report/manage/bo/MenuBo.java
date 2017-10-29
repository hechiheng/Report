package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Menu;
import com.report.manage.dao.iface.MenuDao;

public class MenuBo {
	private DaoManager daoManager;

	private MenuDao dao;

	Logger logger = Logger.getLogger(MenuBo.class);

	public MenuBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (MenuDao) daoManager.getDao(MenuDao.class);
	}

	public List<Menu> getAllMenuList(Menu menu) throws BaseException {
		List<Menu> menuList = dao.selectTopMenuList(menu);
		for (Menu menuT : menuList) {
			menuT.setKeyword(menu.getKeyword());
			List<Menu> subMenuList = dao.selectSubMenuList(menuT);
			menuT.setSubMenuList(subMenuList);
		}
		return menuList;
	}

	public List<Menu> getTopMenuList(Menu menu) throws BaseException {
		return dao.selectTopMenuList(menu);
	}

	public List<Menu> getSubMenuList(Menu menu) throws BaseException {
		return dao.selectSubMenuList(menu);
	}

	public Menu getMenu(int id) throws BaseException {
		return dao.selectMenu(id);
	}

	public void addMenu(Menu menu) throws BaseException {
		dao.insertMenu(menu);
	}

	public void modifyMenu(Menu menu) throws BaseException {
		dao.updateMenu(menu);
	}

	public void modifyMenuIsvalid(Menu menu) throws BaseException {
		dao.updateMenuIsvalid(menu);
	}

	public void removeMenu(int id) throws BaseException {
		dao.deleteMenu(id);
	}

}