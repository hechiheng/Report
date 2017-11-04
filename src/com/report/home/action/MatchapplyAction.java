package com.report.home.action;

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
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;
import com.report.manage.bo.MatchapplyBo;
import com.report.manage.form.MatchapplyForm;

public class MatchapplyAction extends BaseAction {

	public ActionForward load4MatchapplyIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchapplyForm matchapplyForm = (MatchapplyForm) form;
		Matchapply matchapply = matchapplyForm.getMatchapply();
		MatchapplyBo bo = new MatchapplyBo();
		List<Matchapply> matchapplyList = bo.getMatchapplyList(matchapply);
		request.setAttribute("matchapplyList", matchapplyList);
		return mapping.findForward("success");
	}

	public ActionForward load4MatchapplyAdd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchapplyBo bo = new MatchapplyBo();
		List<Matchinfo> matchinfoList = bo.getMatchinfoList();
		request.setAttribute("matchinfoList", matchinfoList);
		return mapping.findForward("success");
	}

	public ActionForward addMatchapply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MatchapplyBo bo = new MatchapplyBo();
		MatchapplyForm matchapplyForm = (MatchapplyForm) form;
		Matchapply matchapply = matchapplyForm.getMatchapply();
		bo.addMatchapply(matchapply);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchapplyAction.addMatchapply.success"));
		smb.setLinkText(new ActionMessage("MatchapplyAction.return"));
		smb.setAction("/load4MatchapplyIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4Matchapply(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchapplyBo bo = new MatchapplyBo();
		Matchapply matchapply = bo.getMatchapply(Integer.valueOf(id));
		request.setAttribute("matchapply", matchapply);
		return mapping.findForward("success");
	}

	public ActionForward load4MatchapplyModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchapplyForm matchapplyForm = (MatchapplyForm) form;
		if (id == null) {
			id = String.valueOf(matchapplyForm.getMatchapply().getId());
		}
		MatchapplyBo bo = new MatchapplyBo();
		Matchapply matchapply = bo.getMatchapply(Integer.valueOf(id));
		matchapplyForm.setMatchapply(matchapply);

		List<Matchinfo> matchinfoList = bo.getMatchinfoList();
		request.setAttribute("matchinfoList", matchinfoList);
		return mapping.findForward("success");
	}

	public ActionForward modifyMatchapply(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchapplyBo bo = new MatchapplyBo();
		MatchapplyForm matchapplyForm = (MatchapplyForm) form;
		Matchapply matchapply = matchapplyForm.getMatchapply();
		bo.modifyMatchapply(matchapply);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchapplyAction.modifyMatchapply.success"));
		smb.setLinkText(new ActionMessage("MatchapplyAction.return"));
		smb.setAction("/load4MatchapplyIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeMatchapply(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchapplyBo bo = new MatchapplyBo();
		bo.removeMatchapply(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchapplyAction.removeMatchapply.success"));
		smb.setLinkText(new ActionMessage("MatchapplyAction.return"));
		smb.setAction("/load4MatchapplyIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}