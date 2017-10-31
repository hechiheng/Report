package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.Menu;
import com.report.manage.bean.Role;
import com.report.manage.dao.iface.RoleDao;

public class RoleSqlMapDao extends SqlMapDaoTemplate implements RoleDao {

	Logger logger = Logger.getLogger("RoleSqlMapDao");

	public RoleSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectRoleListSize(Role role) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.RoleDao.selectRoleListSize", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.selectRoleListSize", e);
			throw new BaseException("manage.RoleDao.selectRoleListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Role> selectRoleList(Role role) throws BaseException {
		try {
			return this.queryForList("manage.RoleDao.selectRoleList", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.selectRoleList", e);
			throw new BaseException("manage.RoleDao.selectRoleList", e);
		}
	}

	public void updateRoleIsvalid(Role role) throws BaseException {
		try {
			this.update("manage.RoleDao.updateRoleIsvalid", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.updateRoleIsvalid", e);
			throw new BaseException("manage.RoleDao.updateRoleIsvalid", e);
		}
	}

	public void deleteRole(int id) throws BaseException {
		try {
			this.delete("manage.RoleDao.deleteRole", id);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.deleteRole", e);
			throw new BaseException("manage.RoleDao.deleteRole", e);
		}
	}

	public void insertRole(Role role) throws BaseException {
		try {
			this.insert("manage.RoleDao.insertRole", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.insertRole", e);
			throw new BaseException("manage.RoleDao.insertRole", e);
		}
	}

	public Role selectRole(int id) throws BaseException {
		try {
			return (Role) this.queryForObject("manage.RoleDao.selectRole", id);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.selectRole", e);
			throw new BaseException("manage.RoleDao.selectRole", e);
		}
	}

	public void updateRole(Role role) throws BaseException {
		try {
			this.update("manage.RoleDao.updateRole", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.updateRole", e);
			throw new BaseException("manage.RoleDao.updateRole", e);
		}
	}

	public void updateRoleIsdisabled(Role role) throws BaseException {
		try {
			this.update("manage.RoleDao.updateRoleIsdisabled", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.updateRoleIsdisabled", e);
			throw new BaseException("manage.RoleDao.updateRoleIsdisabled", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> selectTopMenuList(Role role) throws BaseException {
		try {
			return this.queryForList("manage.RoleDao.selectTopMenuList", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.selectTopMenuList", e);
			throw new BaseException("manage.RoleDao.selectTopMenuList", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> selectSubMenuList(Menu menu) throws BaseException {
		try {
			return this.queryForList("manage.RoleDao.selectSubMenuList", menu);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.selectSubMenuList", e);
			throw new BaseException("manage.RoleDao.selectSubMenuList", e);
		}
	}

	public void insertRoleAccess(Role role) throws BaseException {
		try {
			this.insert("manage.RoleDao.insertRoleAccess", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.insertRoleAccess", e);
			throw new BaseException("manage.RoleDao.insertRoleAccess", e);
		}
	}

	public void deleteRoleAccess(Role role) throws BaseException {
		try {
			this.delete("manage.RoleDao.deleteRoleAccess", role);
		} catch (DaoException e) {
			logger.error("manage.RoleDao.deleteRoleAccess", e);
			throw new BaseException("manage.RoleDao.deleteRoleAccess", e);
		}
	}

}