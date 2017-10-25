package com.report.home.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.Resources;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.home.bean.Announce;
import com.report.home.bo.HomeBo;
import com.report.home.bo.MemberBo;
import com.report.home.form.MemberForm;
import com.report.manage.bean.Member;

public class MemberAction extends BaseAction {

	public ActionForward load4RegMember(ActionMapping mapping, ActionForm form,
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
	
	public ActionForward regMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        MemberBo bo = new MemberBo();
        MemberForm memberForm = (MemberForm) form;
        Member member = memberForm.getMember();
        HttpSession session = request.getSession(false);
        String imagecode = (String) session.getAttribute("imagecode");
        if (!imagecode.equals(member.getImagecode())) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage("MemberAction.regMember.imagecode"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        int cnt=bo.getMemberCount(member.getAccountid());
        if (cnt > 0) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage("MemberAction.regMember.memberExists"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        if(!member.getPassword().equals(member.getPassword_re())){
        	ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage("MemberAction.regMember.password"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        bo.regMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage("MemberAction.regMember.regSuccess", member.getFactname()));
        smb.setLinkText(new ActionMessage("MemberAction.regMember.returnLogin"));
        smb.setAction("load4Login");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

}