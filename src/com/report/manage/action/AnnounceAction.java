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
import com.report.home.bean.Announce;
import com.report.manage.bo.AnnounceBo;
import com.report.manage.form.AnnounceForm;
import com.report.utils.Page;

public class AnnounceAction extends BaseAction {

	public ActionForward load4AnnounceIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		AnnounceForm announceForm = (AnnounceForm) form;
		Announce announce = announceForm.getAnnounce();
		String istrash = request.getParameter("istrash");
		String title = announce.getTitle();
		String p = request.getParameter("p");
		AnnounceBo bo = new AnnounceBo();
		announce.setIsvalid("1".equals(istrash) ? 0 : 1);
		int total = bo.getAnnounceListSize(announce);
		Page page = new Page(total, p, announce, "load4AnnounceIndex");
		page.setQueryData("istrash", istrash == null ? "" : istrash);
		page.setQueryData("announce.title", title == null ? "" : title);
		List<Announce> announceList = bo.getAnnounceList(announce);
		request.setAttribute("announceList", announceList);
		request.setAttribute("page", page);
		request.setAttribute("istrash", istrash);
		return mapping.findForward("success");
	}

	public ActionForward load4AnnounceAdd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward addAnnounce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		AnnounceBo bo = new AnnounceBo();
		AnnounceForm announceForm = (AnnounceForm) form;
		Announce announce = announceForm.getAnnounce();
		announce.setUserid(userid);
		bo.addAnnounce(announce);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("AnnounceAction.addAnnounce.success"));
		smb.setLinkText(new ActionMessage("AnnounceAction.return"));
		smb.setAction("/load4AnnounceIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4AnnounceModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		AnnounceForm announceForm = (AnnounceForm) form;
		AnnounceBo bo = new AnnounceBo();
		Announce announce = bo.getAnnounce(Integer.valueOf(id));
		announceForm.setAnnounce(announce);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward modifyAnnounce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		AnnounceBo bo = new AnnounceBo();
		AnnounceForm announceForm = (AnnounceForm) form;
		Announce announce = announceForm.getAnnounce();
		announce.setUserid(userid);
		bo.modifyAnnounce(announce);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"AnnounceAction.modifyAnnounce.success"));
		smb.setLinkText(new ActionMessage("AnnounceAction.return"));
		smb.setAction("/load4AnnounceIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward trashAnnounce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		AnnounceBo bo = new AnnounceBo();
		Announce announce = new Announce();
		announce.setId(Integer.valueOf(id));
		announce.setUserid(userid);
		announce.setIsvalid(0);
		bo.modifyAnnounceIsvalid(announce);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"AnnounceAction.trashAnnounce.success"));
		smb.setLinkText(new ActionMessage("AnnounceAction.return"));
		smb.setAction("/load4AnnounceIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward restoreAnnounce(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		AnnounceBo bo = new AnnounceBo();
		Announce announce = new Announce();
		announce.setId(Integer.valueOf(id));
		announce.setUserid(userid);
		announce.setIsvalid(1);
		bo.modifyAnnounceIsvalid(announce);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"AnnounceAction.restoreAnnounce.success"));
		smb.setLinkText(new ActionMessage("AnnounceAction.return"));
		smb.setAction("/load4AnnounceIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeAnnounce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		AnnounceBo bo = new AnnounceBo();
		bo.removeAnnounce(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"AnnounceAction.removeAnnounce.success"));
		smb.setLinkText(new ActionMessage("AnnounceAction.return"));
		smb.setAction("/load4AnnounceIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4AnnouncePublish(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		AnnounceForm announceForm = (AnnounceForm) form;
		AnnounceBo bo = new AnnounceBo();
		Announce announce = bo.getAnnounce(Integer.valueOf(id));
		announceForm.setAnnounce(announce);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward publishAnnounce(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		AnnounceBo bo = new AnnounceBo();
		AnnounceForm announceForm = (AnnounceForm) form;
		Announce announce = announceForm.getAnnounce();
		announce.setUserid(userid);
		bo.publishAnnounce(announce);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"AnnounceAction.publishAnnounce.success"));
		smb.setLinkText(new ActionMessage("AnnounceAction.return"));
		smb.setAction("/load4AnnounceIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}