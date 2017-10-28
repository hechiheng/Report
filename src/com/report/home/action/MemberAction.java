package com.report.home.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.Resources;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.home.bean.Announce;
import com.report.home.bean.Member;
import com.report.home.bo.HomeBo;
import com.report.home.bo.MemberBo;
import com.report.manage.form.MemberForm;

public class MemberAction extends BaseAction {

	public ActionForward load4MemberReg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
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
			response.getWriter().println(msg);
		}

		return null;
	}

	public ActionForward regMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MemberBo bo = new MemberBo();
		MemberForm memberForm = (MemberForm) form;
		Member member = memberForm.getMember();
		HttpSession session = request.getSession(false);
		String imagecode = (String) session.getAttribute("imagecode");
		if (!imagecode.equals(member.getImagecode())) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"MemberAction.regMember.imagecode"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		int cnt = bo.getMemberCount(member.getAccountid());
		if (cnt > 0) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"MemberAction.regMember.memberExists"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		if (!member.getPassword().equals(member.getPassword_re())) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"MemberAction.regMember.password"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		bo.regMember(member);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MemberAction.regMember.success",
				member.getFactname()));
		smb
				.setLinkText(new ActionMessage(
						"MemberAction.regMember.returnLogin"));
		smb.setAction("/load4Login");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward load4MemberIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.HOME_SESSION);
		HomeBo homeBo = new HomeBo();
		Announce announce = homeBo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		MemberBo bo = new MemberBo();
		int id = Integer.valueOf(sessionMap.get("memberid"));
		Member member = bo.getMember(id);
		request.setAttribute("member", member);
		return mapping.findForward("success");
	}

	public ActionForward load4MemberChgPwd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward load4MemberModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MemberForm memberForm = (MemberForm) form;
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.HOME_SESSION);
		HomeBo homeBo = new HomeBo();
		Announce announce = homeBo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		MemberBo bo = new MemberBo();
		int id = Integer.valueOf(sessionMap.get("memberid"));
		Member member = bo.getMember(id);
		memberForm.setMember(member);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward modifyMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.HOME_SESSION);
		int id = Integer.valueOf(sessionMap.get("memberid"));
		MemberBo bo = new MemberBo();
		MemberForm memberForm = (MemberForm) form;
		Member member = memberForm.getMember();
		HttpSession session = request.getSession(false);
		String imagecode = (String) session.getAttribute("imagecode");
		if (!imagecode.equals(member.getImagecode())) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"MemberAction.regMember.imagecode"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		member.setId(id);
		bo.modifyMember(member);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MemberAction.modifyMember.success",
				member.getFactname()));
		smb.setLinkText(new ActionMessage("MemberAction.modifyMember.return"));
		smb.setAction("/load4MemberIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward chgMemberPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.HOME_SESSION);
		int id = Integer.valueOf(sessionMap.get("memberid"));
		MemberBo bo = new MemberBo();
		MemberForm chgMemberPwdForm = (MemberForm) form;
		Member member = chgMemberPwdForm.getMember();
		String password_old = member.getPassword_old();
		String password = member.getPassword();
		String password_re = member.getPassword_re();
		Member memberDB = bo.getMember(id);
		String passwordDB = memberDB.getPassword();
		if (!DigestUtils.md5Hex(password_old).equals(passwordDB)) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"MemberAction.chgMemberPwd.wrong"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		if (!password.equals(password_re)) {
			ActionMessages am = new ActionMessages();
			am.add("sysMessage", new ActionMessage(
					"MemberAction.regMember.password"));
			saveErrors(request, am);
			return mapping.findForward("failure");
		}
		member.setId(id);
		bo.modifyMemberPwd(member);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MemberAction.chgMemberPwd.success",
				member.getFactname()));
		smb.setLinkText(new ActionMessage("MemberAction.chgMemberPwd.return"));
		smb.setAction("/load4MemberIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}