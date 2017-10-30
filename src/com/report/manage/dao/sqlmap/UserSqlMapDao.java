package com.report.manage.dao.sqlmap;

import java.util.List;

import org.apache.log4j.Logger;

import com.css.base.BaseException;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.report.manage.bean.Role;
import com.report.manage.bean.User;
import com.report.manage.dao.iface.UserDao;

public class UserSqlMapDao extends SqlMapDaoTemplate implements UserDao {

	Logger logger = Logger.getLogger("UserSqlMapDao");

	public UserSqlMapDao(DaoManager arg0) {
		super(arg0);
	}

	public int selectUserListSize(User user) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.UserDao.selectUserListSize", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.selectUserListSize", e);
			throw new BaseException("manage.UserDao.selectUserListSize", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> selectUserList(User user) throws BaseException {
		try {
			return this.queryForList("manage.UserDao.selectUserList", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.selectUserList", e);
			throw new BaseException("manage.UserDao.selectUserList", e);
		}
	}

	public int selectUserCount(String username) throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.UserDao.selectUserCount", username);
		} catch (DaoException e) {
			logger.error("manage.UserDao.selectUserCount", e);
			throw new BaseException("manage.UserDao.selectUserCount", e);
		}
	}

	public int selectMaxUserid() throws BaseException {
		try {
			return (Integer) this.queryForObject(
					"manage.UserDao.selectMaxUserid", null);
		} catch (DaoException e) {
			logger.error("manage.UserDao.selectMaxUserid", e);
			throw new BaseException("manage.UserDao.selectMaxUserid", e);
		}
	}

	public void updateUserIsvalid(User user) throws BaseException {
		try {
			this.update("manage.UserDao.updateUserIsvalid", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.updateUserIsvalid", e);
			throw new BaseException("manage.UserDao.updateUserIsvalid", e);
		}
	}

	public void deleteUser(int id) throws BaseException {
		try {
			this.delete("manage.UserDao.deleteUser", id);
		} catch (DaoException e) {
			logger.error("manage.UserDao.deleteUser", e);
			throw new BaseException("manage.UserDao.deleteUser", e);
		}
	}

	public void insertUser(User user) throws BaseException {
		try {
			this.insert("manage.UserDao.insertUser", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.insertUser", e);
			throw new BaseException("manage.UserDao.insertUser", e);
		}
	}

	public User selectUser(int id) throws BaseException {
		try {
			return (User) this.queryForObject("manage.UserDao.selectUser", id);
		} catch (DaoException e) {
			logger.error("manage.UserDao.selectUser", e);
			throw new BaseException("manage.UserDao.selectUser", e);
		}
	}

	public void updateUser(User user) throws BaseException {
		try {
			this.update("manage.UserDao.updateUser", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.updateUser", e);
			throw new BaseException("manage.UserDao.updateUser", e);
		}
	}

	public void updateUserPwd(User user) throws BaseException {
		try {
			this.update("manage.UserDao.updateUserPwd", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.updateUserPwd", e);
			throw new BaseException("manage.UserDao.updateUserPwd", e);
		}
	}

	public void updateUserIslock(User user) throws BaseException {
		try {
			this.update("manage.UserDao.updateUserIslock", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.updateUserIslock", e);
			throw new BaseException("manage.UserDao.updateUserIslock", e);
		}
	}

	public void insertRoleUser(User user) throws BaseException {
		try {
			this.insert("manage.UserDao.insertRoleUser", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.insertRoleUser", e);
			throw new BaseException("manage.UserDao.insertRoleUser", e);
		}
	}

	public void updateRoleUser(User user) throws BaseException {
		try {
			this.update("manage.UserDao.updateRoleUser", user);
		} catch (DaoException e) {
			logger.error("manage.UserDao.updateRoleUser", e);
			throw new BaseException("manage.UserDao.updateRoleUser", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Role> selectRoleList() throws BaseException {
		try {
			return this.queryForList("manage.UserDao.selectRoleList", null);
		} catch (DaoException e) {
			logger.error("manage.UserDao.selectRoleList", e);
			throw new BaseException("manage.UserDao.selectRoleList", e);
		}
	}

}