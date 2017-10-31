package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.manage.bean.Menu;
import com.report.manage.bean.Role;

public interface RoleDao {

	public int selectRoleListSize(Role role) throws BaseException;

	public List<Role> selectRoleList(Role role) throws BaseException;

	public void updateRoleIsvalid(Role role) throws BaseException;

	public void deleteRole(int id) throws BaseException;

	public void insertRole(Role role) throws BaseException;

	public Role selectRole(int id) throws BaseException;

	public void updateRole(Role role) throws BaseException;

	public void updateRoleIsdisabled(Role role) throws BaseException;

	public List<Menu> selectTopMenuList(Role role) throws BaseException;

	public List<Menu> selectSubMenuList(Menu menu) throws BaseException;

	public void insertRoleAccess(Role role) throws BaseException;

	public void deleteRoleAccess(Role role) throws BaseException;

}