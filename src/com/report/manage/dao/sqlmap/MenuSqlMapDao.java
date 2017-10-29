package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.Menu;
import com.report.manage.dao.iface.MenuDao;

public class MenuSqlMapDao extends SqlMapDaoTemplate implements MenuDao {

	Logger logger = Logger.getLogger("MenuSqlMapDao");

	public MenuSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> selectTopMenuList(Menu menu) throws BaseException {
		try {
			return this.queryForList("manage.MenuDao.selectTopMenuList", menu);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.selectTopMenuList", e);
			throw new BaseException("manage.MenuDao.selectTopMenuList", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> selectSubMenuList(Menu menu) throws BaseException {
		try {
			return this.queryForList("manage.MenuDao.selectSubMenuList", menu);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.selectSubMenuList", e);
			throw new BaseException("manage.MenuDao.selectSubMenuList", e);
		}
	}

	public Menu selectMenu(int id) throws BaseException {
		try {
			return (Menu) this.queryForObject("manage.MenuDao.selectMenu", id);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.selectMenu", e);
			throw new BaseException("manage.MenuDao.selectMenu", e);
		}
	}

	public void insertMenu(Menu menu) throws BaseException {
		try {
			this.insert("manage.MenuDao.insertMenu", menu);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.insertMenu", e);
			throw new BaseException("manage.MenuDao.insertMenu", e);
		}
	}

	public void updateMenu(Menu menu) throws BaseException {
		try {
			this.update("manage.MenuDao.updateMenu", menu);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.updateMenu", e);
			throw new BaseException("manage.MenuDao.updateMenu", e);
		}
	}

	public void updateMenuIsvalid(Menu menu) throws BaseException {
		try {
			this.update("manage.MenuDao.updateMenuIsvalid", menu);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.updateMenuIsvalid", e);
			throw new BaseException("manage.MenuDao.updateMenuIsvalid", e);
		}
	}

	public void deleteMenu(int id) throws BaseException {
		try {
			this.delete("manage.MenuDao.deleteMenu", id);
		} catch (DaoException e) {
			logger.error("manage.MenuDao.deleteMenu", e);
			throw new BaseException("manage.MenuDao.deleteMenu", e);
		}
	}

}