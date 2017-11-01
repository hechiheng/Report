package com.report.home.interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.css.base.BaseInterceptor;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;

public class MemberInterceptor extends BaseInterceptor {
	private boolean sessionInValid(HttpServletRequest request) {
		Map map_global = SysGlobals.getSessionObj(request, Constants.GLOBAL_SESSION);
		if (map_global != null) {
			if(map_global.get("cfg_website_close").equals("1")){
				SysMessageBean smb = new SysMessageBean(true);
				smb.setMessage(new ActionMessage("error.website_close"));
				SysGlobals.setSysMessage(request, smb);
				return true;
			}
		}
		Map map = SysGlobals.getSessionObj(request, Constants.HOME_SESSION);
		if (map == null) {
			SysMessageBean smb = new SysMessageBean(true);
			smb.setMessage(new ActionMessage("error.session.invalid"));
			smb.setLinkText(new ActionMessage("btn.value.relogin"));
			smb.setAction("/load4Login");
			smb.setLinkTarget("_parent");
			SysGlobals.setSysMessage(request, smb);
			return true;
		}
		return false;
	}

	public ActionForward before_load4MemberIndex(Action action,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (sessionInValid(request)) {
			return mapping.findForward("error");
		}
		return null;
	}

	public ActionForward before_load4MemberChgPwd(Action action,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (sessionInValid(request)) {
			return mapping.findForward("error");
		}
		return null;
	}

	public ActionForward before_load4MemberEdit(Action action,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (sessionInValid(request)) {
			return mapping.findForward("error");
		}
		return null;
	}

	public ActionForward before_regMember(Action action, ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (sessionInValid(request)) {
			return mapping.findForward("error");
		}
		return null;
	}

	public ActionForward before_editMember(Action action,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (sessionInValid(request)) {
			return mapping.findForward("error");
		}
		return null;
	}

	public ActionForward before_chgMemberPwd(Action action,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (sessionInValid(request)) {
			return mapping.findForward("error");
		}
		return null;
	}

	public ActionForward afterAction(Action arg0, ActionMapping arg1,
			ActionForm arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws IOException, ServletException {
		return null;
	}
}
