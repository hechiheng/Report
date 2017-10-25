package com.report.manage.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
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
import com.report.manage.bean.User;
import com.report.manage.bo.LoginBo;
import com.report.utils.CheckCodeImage;

public class LoginAction extends BaseAction {

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		LoginBo loginBo = new LoginBo();
		DynaValidatorForm loginForm = (DynaValidatorForm) form;
		String username = loginForm.getString("username");

		String password = loginForm.getString("password");
		String imagecode = loginForm.getString("imagecode");
		String flag = "success";
		HttpSession session = request.getSession(false);

		session.removeAttribute("username");
		if (!imagecode.equals(session.getAttribute("imagecode"))) {
			flag = "failure";
			ActionMessages msg = new ActionMessages();
			msg.add("sysMessage", new ActionMessage(
					"LoginAction.login.imagecode"));
			saveErrors(request, msg);
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			try {
				User userDB = loginBo.getUserInfo(user);
				if (userDB != null) {
					Map<String, String> sessionMap = new HashMap<String, String>();
					sessionMap.put("userid", userDB.getId());
					sessionMap.put("username", userDB.getUsername());
					sessionMap.put("realname", userDB.getRealname());
					sessionMap.put("usertype", userDB.getUsertype());
					SysGlobals.setSessionObj(request, Constants.MAIN_SESSION,
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

	/**
	 * 到后台首页
	 * 
	 * 焦艳阳 2007-2-7
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward load4Index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	/**
	 * 获取验证码
	 * 
	 * 焦艳阳 2007-2-7
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
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

	/**
	 * 到后台登陆页面
	 * 
	 * 焦艳阳 2007-2-7
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward load4Login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	/**
	 * 退出系统方法
	 * 
	 * 焦艳阳 2007-3-3
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		SysGlobals.removeSessionObj(request, Constants.MAIN_SESSION);
		HttpSession session = request.getSession(false);
		session.removeAttribute("queryString");
		return mapping.findForward("logoutFrw");
	}

	/**
	 * 加载后台管理界面的左侧页面
	 * 
	 * 杨赞明 2007-3-7
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward load4Left(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("load4Left");
	}

	/**
	 * 加载后台管理界面的右侧页面
	 * 
	 * 赵志强 2007-3-8
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward load4Right(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("load4Right");
	}

	/**
	 * 
	 * 功能：
	 * 
	 * 作者:刘婷 2008-7-15
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward userIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		return mapping.findForward("userIndex");

	}

	/**
	 * 
	 * 功能：
	 * 
	 * 作者:刘婷 2008-7-15
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward checkUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		return mapping.findForward("checkUser");

	}

}