package com.report.home.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.css.base.BaseException;
import com.css.base.BaseInterceptor;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.home.bo.HomeBo;
import com.report.manage.bean.Website;

public class MatchapplyInterceptor extends BaseInterceptor {

	public ActionForward beforeAction(Action action, ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Map map = SysGlobals.getSessionObj(request, Constants.HOME_SESSION);
		if (map == null) {
			SysMessageBean smb = new SysMessageBean(true);
			smb.setMessage(new ActionMessage("error.session.invalid"));
			smb.setLinkText(new ActionMessage("btn.value.relogin"));
			smb.setAction("/load4Login");
			smb.setLinkTarget("_parent");
			SysGlobals.setSysMessage(request, smb);
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
