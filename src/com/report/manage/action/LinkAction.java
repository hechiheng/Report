package com.report.manage.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.home.bean.Link;
import com.report.manage.bo.LinkBo;
import com.report.manage.form.LinkForm;

public class LinkAction extends BaseAction {

	public ActionForward load4LinkIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		LinkForm linkForm = (LinkForm) form;
		Link link = linkForm.getLink();
		LinkBo bo = new LinkBo();
		List<Link> linkList = bo.getLinkList(link);
		request.setAttribute("linkList", linkList);
		return mapping.findForward("success");
	}

	public ActionForward load4LinkAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward addLink(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		LinkBo bo = new LinkBo();
		LinkForm linkForm = (LinkForm) form;
		Link link = linkForm.getLink();
		link.setUserid(userid);
		bo.addLink(link);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("LinkAction.addLink.success"));
		smb.setLinkText(new ActionMessage("LinkAction.return"));
		smb.setAction("/load4LinkIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4LinkModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		LinkForm linkForm = (LinkForm) form;
		LinkBo bo = new LinkBo();
		Link link = bo.getLink(Integer.valueOf(id));
		linkForm.setLink(link);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward modifyLink(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		LinkBo bo = new LinkBo();
		LinkForm linkForm = (LinkForm) form;
		Link link = linkForm.getLink();
		link.setUserid(userid);
		bo.modifyLink(link);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("LinkAction.modifyLink.success"));
		smb.setLinkText(new ActionMessage("LinkAction.return"));
		smb.setAction("/load4LinkIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward trashLink(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		LinkBo bo = new LinkBo();
		Link link = new Link();
		link.setId(Integer.valueOf(id));
		link.setUserid(userid);
		link.setIsvalid(0);
		bo.modifyLinkIsvalid(link);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("LinkAction.trashLink.success"));
		smb.setLinkText(new ActionMessage("LinkAction.return"));
		smb.setAction("/load4LinkIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}