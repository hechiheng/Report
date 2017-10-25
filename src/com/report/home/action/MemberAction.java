package com.report.home.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.Resources;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.home.bean.Announce;
import com.report.home.bo.HomeBo;
import com.report.home.bo.MemberBo;

public class MemberAction extends BaseAction {

	public ActionForward load4MemberReg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HomeBo bo = new HomeBo();
		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		return mapping.findForward("success");
	}

	public ActionForward load4MemberLogin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		HomeBo bo = new HomeBo();
		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		return mapping.findForward("success");
	}

	public ActionForward verifyMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException, IOException {
		String accountid = request.getParameter("accountid");
		MemberBo bo = new MemberBo();
		String key = bo.verifyMember(accountid);
		if (!key.equals("")) {
			MessageResources resource = Resources.getMessageResources(request);
			String msg = resource.getMessage(key);
			System.out.println("============msg=" + msg);
			response.getWriter().println(msg);
		}

		return null;
	}

}