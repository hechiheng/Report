package com.report.home.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.home.bo.LoginBo;
import com.report.manage.bean.Member;

public class LoginAction extends BaseAction {

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		LoginBo loginBo = new LoginBo();
		DynaValidatorForm loginForm = (DynaValidatorForm) form;
		String accountid = loginForm.getString("accountid");

		String password = loginForm.getString("password");
		String imagecode = loginForm.getString("imagecode");
		String flag = "success";
		HttpSession session = request.getSession(false);

		session.removeAttribute("accountid");
		if (!imagecode.equals(session.getAttribute("imagecode"))) {
			flag = "failure";
			ActionMessages msg = new ActionMessages();
			msg.add("sysMessage", new ActionMessage(
					"LoginAction.login.imagecode"));
			saveErrors(request, msg);
		} else {
			Member member = new Member();
			member.setAccountid(accountid);
			member.setPassword(password);

			try {
				Member memberDB = loginBo.getMember(member);
				if (memberDB != null) {
					Map<String, String> sessionMap = new HashMap<String, String>();
					sessionMap.put("memberid", memberDB.getId());
					sessionMap.put("accountid", memberDB.getAccountid());
					sessionMap.put("factname", memberDB.getFactname());
					SysGlobals.setSessionObj(request, Constants.MAIN_SESSION,
							sessionMap);
				} else {
					ActionMessages msg = new ActionMessages();
					msg.add("sysMessage", new ActionMessage(
							"LoginAction.login.failed"));
					saveErrors(request, msg);
					flag = "failure";
				}
			} catch (BaseException e) {
				throw new BaseException("errors.not.connect.db", e);
			}
		}
		return mapping.findForward(flag);
	}

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		SysGlobals.removeSessionObj(request, Constants.MAIN_SESSION);
		return mapping.findForward("success");
	}

	public ActionForward load4Index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward load4Login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward load4MemberIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward load4MemberChgPwd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward load4MemberEdit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

}