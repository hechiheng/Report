package com.report.manage.bo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoManager;
import com.report.global.Constants;
import com.report.global.DaoConfig;
import com.report.manage.bean.Role;
import com.report.manage.bean.User;
import com.report.manage.dao.iface.UserDao;

public class UserBo {
	private DaoManager daoManager;

	private UserDao dao;

	Logger logger = Logger.getLogger(UserBo.class);

	public UserBo() throws BaseException {
		this.daoManager = DaoConfig.getDaoManager();
		this.dao = (UserDao) daoManager.getDao(UserDao.class);
	}

	public int getUserListSize(User user) throws BaseException {
		return dao.selectUserListSize(user);
	}

	public List<User> getUserList(User user) throws BaseException {
		return dao.selectUserList(user);
	}

	public int getUserCount(String username) throws BaseException {
		return dao.selectUserCount(username);
	}

	public User getUser(int id) throws BaseException {
		return dao.selectUser(id);
	}

	public String verifyUser(String username) throws BaseException {
		String key = "";
		if (dao.selectUserCount(username) > 0) {
			key = "user.exist";
		} else if (!this.verify(username)) {
			key = "user.invalid";
		}
		return key;

	}

	public boolean verify(String username) {
		Pattern p = Pattern.compile("^[0-9a-zA-Z]*$");
		Matcher m = p.matcher(username);
		return m.matches();
	}

	public void addUser(User user) throws BaseException {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		int id = dao.selectMaxUserid();
		user.setId(id);
		try {
			daoManager.startTransaction();
			dao.insertUser(user);
			dao.insertRoleUser(user);
			daoManager.commitTransaction();
		} catch (Exception e) {
			logger.error("manage.UserBo.addUser", e);
			throw new BaseException("manage.UserBo.addUser", e);
		} finally {
			daoManager.endTransaction();
		}
	}

	public void modifyUser(User user) throws BaseException {
		try {
			daoManager.startTransaction();
			dao.updateUser(user);
			dao.updateRoleUser(user);
			daoManager.commitTransaction();
		} catch (Exception e) {
			logger.error("manage.UserBo.modifyUser", e);
			throw new BaseException("manage.UserBo.modifyUser", e);
		} finally {
			daoManager.endTransaction();
		}
	}

	public void modifyUserIsvalid(User user) throws BaseException {
		dao.updateUserIsvalid(user);
	}

	public void resetUserPwd(User user) throws BaseException {
		user.setPassword(DigestUtils.md5Hex(Constants.DEFAULT_PWD));
		dao.updateUserPwd(user);
	}

	public void removeUser(int id) throws BaseException {
		dao.deleteUser(id);
	}

	public void lockUser(User user) throws BaseException {
		dao.updateUserIslock(user);
	}

	public void addRoleUser(User user) throws BaseException {
		dao.insertRoleUser(user);
	}

	public void modifyRoleUser(User user) throws BaseException {
		dao.updateRoleUser(user);
	}

	public List<Role> getRoleList() throws BaseException {
		return dao.selectRoleList();
	}

	public void modifyUserPwd(User user) throws BaseException {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		dao.updateUserPwd(user);
	}

}