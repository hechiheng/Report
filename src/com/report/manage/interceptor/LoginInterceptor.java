package com.report.manage.interceptor;

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

public class LoginInterceptor extends BaseInterceptor {

	public ActionForward before_load4Index(Action action,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		ActionForward af = null;
		Map map = SysGlobals.getSessionObj(request, Constants.MANAGE_SESSION);
		if (map == null) {
			SysMessageBean smb = new SysMessageBean(true);
			smb.setMessage(new ActionMessage("error.session.invalid"));
			smb.setLinkText(new ActionMessage("btn.value.relogin"));
			smb.setAction("/load4Login");
			smb.setLinkTarget("_parent");
			SysGlobals.setSysMessage(request, smb);
			af = mapping.findForward("error");
		}
		return af;
	}

	public ActionForward afterAction(Action arg0, ActionMapping arg1,
			ActionForm arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws IOException, ServletException {
		return null;
	}
}
