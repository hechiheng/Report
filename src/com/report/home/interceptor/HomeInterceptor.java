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

public class HomeInterceptor extends BaseInterceptor {

	public ActionForward beforeAction(Action action, ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Map map_global = SysGlobals.getSessionObj(request,
				Constants.GLOBAL_SESSION);
		if (map_global == null) {
			try {
				HomeBo bo = new HomeBo();
				Website website = bo.getWebsite();
				Map<String, String> sessionMap = new HashMap<String, String>();
				sessionMap.put("cfg_webname", website.getCfg_webname());
				sessionMap.put("cfg_webtitle", website.getCfg_webtitle());
				sessionMap.put("cfg_themestyle", website.getCfg_themestyle());
				sessionMap.put("cfg_keywords", website.getCfg_keywords());
				sessionMap.put("cfg_description", website.getCfg_description());
				sessionMap.put("cfg_powerby", website.getCfg_powerby());
				sessionMap.put("cfg_recordno", website.getCfg_recordno());
				sessionMap.put("cfg_address", website.getCfg_address());
				sessionMap.put("cfg_phone", website.getCfg_phone());
				sessionMap.put("cfg_qq", website.getCfg_qq());
				sessionMap.put("cfg_email", website.getCfg_email());
				SysGlobals.setSessionObj(request, Constants.GLOBAL_SESSION,
						sessionMap);
				map_global = sessionMap;
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward afterAction(Action arg0, ActionMapping arg1,
			ActionForm arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws IOException, ServletException {
		return null;
	}
}
