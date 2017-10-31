package com.report.manage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.Resources;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.manage.bean.Role;
import com.report.manage.bean.User;
import com.report.manage.bo.UserBo;
import com.report.manage.form.UserForm;
import com.report.utils.Page;

public class UserAction extends BaseAction {

	public ActionForward load4UserIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		UserForm userForm = (UserForm) form;
		User user = userForm.getUser();
		String istrash = request.getParameter("istrash");
		String username = user.getUsername();
		String p = request.getParameter("p");
		UserBo bo = new UserBo();
		user.setIsvalid("1".equals(istrash) ? 0 : 1);
		int total = bo.getUserListSize(user);
		Page page = new Page(total, p, user, "load4UserIndex");
		page.setQueryData("istrash", istrash == null ? "" : istrash);
		page.setQueryData("user.username", username == null ? "" : username);
		List<User> userList = bo.getUserList(user);
		request.setAttribute("userList", userList);
		request.setAttribute("page", page);
		request.setAttribute("istrash", istrash);
		return mapping.findForward("success");
	}

	public ActionForward load4UserAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		UserBo bo = new UserBo();
		List<Role> roleList = bo.getRoleList();
		request.setAttribute("roleList", roleList);
		return mapping.findForward("success");
	}

	public ActionForward verifyUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException, IOException {
		String username = request.getParameter("username");
		UserBo bo = new UserBo();
		String key = bo.verifyUser(username);
		if (!key.equals("")) {
			MessageResources resource = Resources.getMessageResources(request);
			String msg = resource.getMessage(key);
			response.getWriter().println(msg);
		}

		return null;
	}

	public ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		UserBo bo = new UserBo();
		UserForm userForm = (UserForm) form;
		User user = userForm.getUser();
		int cnt = bo.getUserCount(user.getUsername());
		if (cnt > 0) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"UserAction.addUser.usernameExists"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		if (!user.getPassword().equals(user.getPassword_re())) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"UserAction.addUser.password"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}

		bo.addUser(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.addUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.addUser.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4UserInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		UserBo bo = new UserBo();
		User user = bo.getUser(Integer.valueOf(id));
		request.setAttribute("user", user);
		return mapping.findForward("success");
	}

	public ActionForward load4UserModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		UserForm userForm = (UserForm) form;
		UserBo bo = new UserBo();
		User user = bo.getUser(Integer.valueOf(id));
		userForm.setUser(user);

		List<Role> roleList = bo.getRoleList();
		request.setAttribute("roleList", roleList);
		return mapping.findForward("success");
	}

	public ActionForward modifyUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		UserBo bo = new UserBo();
		UserForm userForm = (UserForm) form;
		User user = userForm.getUser();
		bo.modifyUser(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.modifyUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.modifyUser.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward trashUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		UserBo bo = new UserBo();
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setIsvalid(0);
		bo.modifyUserIsvalid(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.trashUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.trashUser.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward restoreUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		UserBo bo = new UserBo();
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setIsvalid(1);
		bo.modifyUserIsvalid(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.restoreUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.restoreUser.return"));
		smb.setAction("/load4UserIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		UserBo bo = new UserBo();
		bo.removeUser(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.removeUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.removeUser.return"));
		smb.setAction("/load4UserIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward resetUserPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.valueOf(id));
		UserBo bo = new UserBo();
		bo.resetUserPwd(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.resetUserPwd.success"));
		smb.setLinkText(new ActionMessage("UserAction.resetUserPwd.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward lockUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setIslock(1);
		UserBo bo = new UserBo();
		bo.lockUser(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.lockUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.lockUser.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward unLockUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setIslock(0);
		UserBo bo = new UserBo();
		bo.lockUser(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.unLockUser.success"));
		smb.setLinkText(new ActionMessage("UserAction.unLockUser.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4UserPwdModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		UserForm userForm = (UserForm) form;
		User user = userForm.getUser();
		user.setId(Integer.valueOf(id));
		userForm.setUser(user);
		return mapping.findForward("success");
	}

	public ActionForward modifyUserPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		UserBo bo = new UserBo();
		UserForm userForm = (UserForm) form;
		User user = userForm.getUser();
		String password_old = user.getPassword_old();
		String password = user.getPassword();
		String password_re = user.getPassword_re();
		User userDB = bo.getUser(user.getId());
		String passwordDB = userDB.getPassword();
		if (!DigestUtils.md5Hex(password_old).equals(passwordDB)) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"UserAction.modifyUserPwd.wrong"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		if (!password.equals(password_re)) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"UserAction.modifyUserPwd.password"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		bo.modifyUserPwd(user);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("UserAction.modifyUserPwd.success",
				user.getFactname()));
		smb.setLinkText(new ActionMessage("UserAction.modifyUserPwd.return"));
		smb.setAction("/load4UserIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}