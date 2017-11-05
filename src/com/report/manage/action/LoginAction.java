package com.report.manage.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.manage.bean.Menu;
import com.report.manage.bean.User;
import com.report.manage.bo.LoginBo;
import com.report.utils.CheckCodeImage;

public class LoginAction extends BaseAction {

	public ActionForward load4Login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		LoginBo bo = new LoginBo();
		DynaValidatorForm loginForm = (DynaValidatorForm) form;
		String username = loginForm.getString("username");

		String password = loginForm.getString("password");
		String imagecode = loginForm.getString("imagecode");
		String flag = "index";
		HttpSession session = request.getSession(false);

		session.removeAttribute("username");
		if (!imagecode.equals(session.getAttribute("imagecode"))) {
			flag = "failure";
			ActionMessages msg = new ActionMessages();
			msg.add("sysMessage", new ActionMessage("error.input.imagecode"));
			saveErrors(request, msg);
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			try {
				User userDB = bo.getUserInfo(user);
				if (userDB != null) {
					Map<String, String> sessionMap = new HashMap<String, String>();
					sessionMap.put("userid", String.valueOf(userDB.getId()));
					sessionMap.put("username", userDB.getUsername());
					sessionMap.put("factname", userDB.getFactname());
					sessionMap.put("usertype", String.valueOf(userDB
							.getUsertype()));
					SysGlobals.setSessionObj(request, Constants.MANAGE_SESSION,
							sessionMap);
				} else {
					ActionMessages msg = new ActionMessages();
					msg.add("sysMessage", new ActionMessage(
							"LoginAction.login.failed"));
					saveErrors(request, msg);
					flag = "failure";
				}
			} catch (BaseException e) {
				throw new BaseException("errors.not.connect.db", e);
			}
		}
		return mapping.findForward(flag);
	}

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		SysGlobals.removeSessionObj(request, Constants.MANAGE_SESSION);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward load4Index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		LoginBo bo = new LoginBo();
		List<Menu> menuList = bo.getMenuList(userid);
		request.setAttribute("menuList", menuList);
		return mapping.findForward("success");
	}

	public ActionForward imageCode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		CheckCodeImage cci = new CheckCodeImage(CheckCodeImage.NUM);
		HttpSession session = request.getSession(false);
		try {
			response.setContentType("image/jpeg");
			OutputStream os = response.getOutputStream();
			ImageIO.write(cci.getImage(), "PNG", os);
			session.setAttribute("imagecode", cci.getRandCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw new BaseException("LoginAction.imageCheck");
		}
		return null;
	}

}