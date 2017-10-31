package com.report.manage.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.DaoConfig;
import com.report.manage.bean.Menu;
import com.report.manage.bean.Role;
import com.report.manage.dao.iface.RoleDao;

public class RoleBo {
	private DaoManager daoManager;

	private RoleDao dao;

	Logger logger = Logger.getLogger(RoleBo.class);

	public RoleBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (RoleDao) daoManager.getDao(RoleDao.class);
	}

	public int getRoleListSize(Role role) throws BaseException {
		return dao.selectRoleListSize(role);
	}

	public List<Role> getRoleList(Role role) throws BaseException {
		return dao.selectRoleList(role);
	}

	public Role getRole(int id) throws BaseException {
		return dao.selectRole(id);
	}

	public void addRole(Role role) throws BaseException {
		dao.insertRole(role);
	}

	public void modifyRole(Role role) throws BaseException {
		dao.updateRole(role);
	}

	public void modifyRoleIsvalid(Role role) throws BaseException {
		dao.updateRoleIsvalid(role);
	}

	public void removeRole(int id) throws BaseException {
		dao.deleteRole(id);
	}

	public void disabledRole(Role role) throws BaseException {
		dao.updateRoleIsdisabled(role);
	}

	public List<Menu> getAllMenuList(Role role) throws BaseException {
		List<Menu> menuList = dao.selectTopMenuList(role);
		for (Menu menuT : menuList) {
			menuT.setRoleid(role.getId());
			List<Menu> subMenuList = dao.selectSubMenuList(menuT);
			menuT.setSubMenuList(subMenuList);
		}
		return menuList;
	}

	public void modifyRoleAccess(Role role) throws BaseException {
		String[] menuidArr = role.getMenuids().split(",");
		try {
			daoManager.startTransaction();
			dao.deleteRoleAccess(role);
			for (String menuid : menuidArr) {
				role.setMenuid(Integer.valueOf(menuid));
				dao.insertRoleAccess(role);
			}
			daoManager.commitTransaction();
		} catch (Exception e) {
			logger.error("manage.RoleBo.modifyRoleAccess", e);
			throw new BaseException("manage.RoleBo.modifyRoleAccess", e);
		} finally {
			daoManager.endTransaction();
		}
	}

}