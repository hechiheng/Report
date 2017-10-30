package com.report.manage.dao.iface;

import java.util.List;

import com.css.base.BaseException;
import com.report.manage.bean.Role;
import com.report.manage.bean.User;

public interface UserDao {

	public int selectUserListSize(User user) throws BaseException;

	public List<User> selectUserList(User user) throws BaseException;

	public int selectUserCount(String username) throws BaseException;

	public int selectMaxUserid() throws BaseException;

	public void updateUserIsvalid(User user) throws BaseException;

	public void deleteUser(int id) throws BaseException;

	public void insertUser(User user) throws BaseException;

	public User selectUser(int id) throws BaseException;

	public void updateUser(User user) throws BaseException;

	public void updateUserPwd(User user) throws BaseException;

	public void updateUserIslock(User user) throws BaseException;

	public void insertRoleUser(User user) throws BaseException;

	public void updateRoleUser(User user) throws BaseException;

	public List<Role> selectRoleList() throws BaseException;

}