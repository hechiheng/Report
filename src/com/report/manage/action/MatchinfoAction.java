package com.report.manage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.manage.bean.Matchinfo;
import com.report.manage.bean.Matchtype;
import com.report.manage.bo.MatchinfoBo;
import com.report.manage.form.MatchinfoForm;
import com.report.utils.Page;

public class MatchinfoAction extends BaseAction {

	public ActionForward load4MatchinfoIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchinfoForm matchinfoForm = (MatchinfoForm) form;
		Matchinfo matchinfo = matchinfoForm.getMatchinfo();
		String istrash = request.getParameter("istrash");
		String name = matchinfo.getName();
		String p = request.getParameter("p");
		MatchinfoBo bo = new MatchinfoBo();
		matchinfo.setIsvalid("1".equals(istrash) ? 0 : 1);
		int total = bo.getMatchinfoListSize(matchinfo);
		Page page = new Page(total, p, matchinfo, "load4MatchinfoIndex");
		page.setQueryData("istrash", istrash == null ? "" : istrash);
		page.setQueryData("matchinfo.name", name == null ? "" : name);
		List<Matchinfo> matchinfoList = bo.getMatchinfoList(matchinfo);
		request.setAttribute("matchinfoList", matchinfoList);
		request.setAttribute("page", page);
		request.setAttribute("istrash", istrash);
		return mapping.findForward("success");
	}

	public ActionForward load4MatchinfoAdd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchinfoBo bo = new MatchinfoBo();
		List<Matchtype> matchtypeList = bo.getMatchtypeList();
		request.setAttribute("matchtypeList", matchtypeList);
		return mapping.findForward("success");
	}

	public ActionForward addMatchinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MatchinfoBo bo = new MatchinfoBo();
		MatchinfoForm matchinfoForm = (MatchinfoForm) form;
		Matchinfo matchinfo = matchinfoForm.getMatchinfo();
		bo.addMatchinfo(matchinfo);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"MatchinfoAction.addMatchinfo.success"));
		smb.setLinkText(new ActionMessage("MatchinfoAction.return"));
		smb.setAction("/load4MatchinfoIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4Matchinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		MatchinfoBo bo = new MatchinfoBo();
		Matchinfo matchinfo = bo.getMatchinfo(Integer.valueOf(id));
		request.setAttribute("matchinfo", matchinfo);
		return mapping.findForward("success");
	}

	public ActionForward load4MatchinfoModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchinfoForm matchinfoForm = (MatchinfoForm) form;
		if (id == null) {
			id = String.valueOf(matchinfoForm.getMatchinfo().getId());
		}
		MatchinfoBo bo = new MatchinfoBo();
		Matchinfo matchinfo = bo.getMatchinfo(Integer.valueOf(id));
		matchinfoForm.setMatchinfo(matchinfo);

		List<Matchtype> matchtypeList = bo.getMatchtypeList();
		request.setAttribute("matchtypeList", matchtypeList);
		return mapping.findForward("success");
	}

	public ActionForward modifyMatchinfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchinfoBo bo = new MatchinfoBo();
		MatchinfoForm matchinfoForm = (MatchinfoForm) form;
		Matchinfo matchinfo = matchinfoForm.getMatchinfo();
		bo.modifyMatchinfo(matchinfo);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchinfoAction.modifyMatchinfo.success"));
		smb.setLinkText(new ActionMessage("MatchinfoAction.return"));
		smb.setAction("/load4MatchinfoIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward trashMatchinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		MatchinfoBo bo = new MatchinfoBo();
		Matchinfo matchinfo = new Matchinfo();
		matchinfo.setId(Integer.valueOf(id));
		matchinfo.setIsvalid(0);
		bo.modifyMatchinfoIsvalid(matchinfo);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchinfoAction.trashMatchinfo.success"));
		smb.setLinkText(new ActionMessage("MatchinfoAction.return"));
		smb.setAction("/load4MatchinfoIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward restoreMatchinfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchinfoBo bo = new MatchinfoBo();
		Matchinfo matchinfo = new Matchinfo();
		matchinfo.setId(Integer.valueOf(id));
		matchinfo.setIsvalid(1);
		bo.modifyMatchinfoIsvalid(matchinfo);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchinfoAction.restoreMatchinfo.success"));
		smb.setLinkText(new ActionMessage("MatchinfoAction.return"));
		smb.setAction("/load4MatchinfoIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeMatchinfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchinfoBo bo = new MatchinfoBo();
		bo.removeMatchinfo(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchinfoAction.removeMatchinfo.success"));
		smb.setLinkText(new ActionMessage("MatchinfoAction.return"));
		smb.setAction("/load4MatchinfoIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}