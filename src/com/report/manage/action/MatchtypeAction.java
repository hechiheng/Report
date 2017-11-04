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
import com.report.manage.bean.Matchtype;
import com.report.manage.bo.MatchtypeBo;
import com.report.manage.form.MatchtypeForm;

public class MatchtypeAction extends BaseAction {

	public ActionForward load4MatchtypeIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchtypeForm matchtypeForm = (MatchtypeForm) form;
		Matchtype matchtype = matchtypeForm.getMatchtype();
		MatchtypeBo bo = new MatchtypeBo();
		List<Matchtype> matchtypeList = bo.getMatchtypeList(matchtype);
		request.setAttribute("matchtypeList", matchtypeList);
		return mapping.findForward("success");
	}

	public ActionForward load4MatchtypeAdd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward addMatchtype(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MatchtypeBo bo = new MatchtypeBo();
		MatchtypeForm matchtypeForm = (MatchtypeForm) form;
		Matchtype matchtype = matchtypeForm.getMatchtype();
		bo.addMatchtype(matchtype);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"MatchtypeAction.addMatchtype.success"));
		smb.setLinkText(new ActionMessage("MatchtypeAction.return"));
		smb.setAction("/load4MatchtypeIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4MatchtypeInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchtypeBo bo = new MatchtypeBo();
		Matchtype matchtype = bo.getMatchtype(Integer.valueOf(id));
		request.setAttribute("matchtype", matchtype);
		return mapping.findForward("success");
	}

	public ActionForward load4MatchtypeModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MatchtypeForm matchtypeForm = (MatchtypeForm) form;
		if (id == null) {
			id = String.valueOf(matchtypeForm.getMatchtype().getId());
		}
		MatchtypeBo bo = new MatchtypeBo();
		Matchtype matchtype = bo.getMatchtype(Integer.valueOf(id));
		matchtypeForm.setMatchtype(matchtype);
		return mapping.findForward("success");
	}

	public ActionForward modifyMatchtype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MatchtypeBo bo = new MatchtypeBo();
		MatchtypeForm matchtypeForm = (MatchtypeForm) form;
		Matchtype matchtype = matchtypeForm.getMatchtype();
		bo.modifyMatchtype(matchtype);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchtypeAction.modifyMatchtype.success"));
		smb.setLinkText(new ActionMessage("MatchtypeAction.return"));
		smb.setAction("/load4MatchtypeIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward trashMatchtype(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		MatchtypeBo bo = new MatchtypeBo();
		Matchtype matchtype = new Matchtype();
		matchtype.setId(Integer.valueOf(id));
		matchtype.setIsvalid(0);
		bo.modifyMatchtypeIsvalid(matchtype);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchtypeAction.trashMatchtype.success"));
		smb.setLinkText(new ActionMessage("MatchtypeAction.return"));
		smb.setAction("/load4MatchtypeIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward disabledMatchtype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		Matchtype matchtype = new Matchtype();
		matchtype.setId(Integer.valueOf(id));
		matchtype.setIsdisabled(1);
		MatchtypeBo bo = new MatchtypeBo();
		bo.disabledMatchtype(matchtype);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchtypeAction.disabledMatchtype.success"));
		smb.setLinkText(new ActionMessage("MatchtypeAction.return"));
		smb.setAction("/load4MatchtypeIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward enableMatchtype(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		Matchtype matchtype = new Matchtype();
		matchtype.setId(Integer.valueOf(id));
		matchtype.setIsdisabled(0);
		MatchtypeBo bo = new MatchtypeBo();
		bo.disabledMatchtype(matchtype);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage(
				"MatchtypeAction.enableMatchtype.success"));
		smb.setLinkText(new ActionMessage("MatchtypeAction.return"));
		smb.setAction("/load4MatchtypeIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}