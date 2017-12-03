package com.report.manage.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.report.home.bean.Member;
import com.report.manage.bo.MemberBo;
import com.report.manage.form.MemberForm;
import com.report.utils.Page;

public class MemberAction extends BaseAction {

    public ActionForward load4MemberIndex(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        MemberForm memberForm = (MemberForm) form;
        Member member = memberForm.getMember();
        String istrash = request.getParameter("istrash");
        String accountid = member.getAccountid();
        String factname = member.getFactname();
        String p = request.getParameter("p");
        MemberBo bo = new MemberBo();
        member.setIsvalid("1".equals(istrash) ? 0 : 1);
        int total = bo.getMemberListSize(member);
        Page page = new Page(total, p, member, "load4MemberIndex");
        page.setQueryData("istrash", istrash == null ? "" : istrash);
        page.setQueryData("member.accountid", accountid == null ? ""
                : accountid);
        page.setQueryData("member.factname", factname == null ? "" : factname);
        List<Member> memberList = bo.getMemberList(member);
        request.setAttribute("memberList", memberList);
        request.setAttribute("page", page);
        request.setAttribute("istrash", istrash);
        return mapping.findForward("success");
    }

    public ActionForward load4MemberAdd(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
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

    public ActionForward addMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        MemberBo bo = new MemberBo();
        MemberForm memberForm = (MemberForm) form;
        Member member = memberForm.getMember();
        int cnt = bo.getMemberCount(member.getAccountid());
        if (cnt > 0) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage(
                    "manage.MemberAction.addMember.accountidExists"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        if (!member.getPassword().equals(member.getPassword_re())) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage(
                    "manage.MemberAction.addMember.password"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }

        bo.addMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.addMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    @SuppressWarnings("unchecked")
    public ActionForward load4MemberInfo(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        String id = request.getParameter("id");
        if (id == null) {
            Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                    Constants.MANAGE_SESSION);
            id = sessionMap.get("memberid");
        }
        MemberBo bo = new MemberBo();
        Member member = bo.getMember(Integer.valueOf(id));
        request.setAttribute("member", member);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward load4MemberModify(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        String id = sessionMap.get("memberid");
        MemberForm memberForm = (MemberForm) form;
        MemberBo bo = new MemberBo();
        Member member = bo.getMember(Integer.valueOf(id));
        memberForm.setMember(member);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward modifyMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        String id = sessionMap.get("memberid");
        MemberBo bo = new MemberBo();
        MemberForm memberForm = (MemberForm) form;
        Member member = memberForm.getMember();
        member.setId(Integer.valueOf(id));
        bo.modifyMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.modifyMember.success"));
        smb.setAction("/load4MemberModify");
        smb
                .setLinkText(new ActionMessage(
                        "UserAction.modifyUser.returnModify"));
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward trashMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        MemberBo bo = new MemberBo();
        Member member = new Member();
        member.setId(Integer.valueOf(id));
        member.setIsvalid(0);
        bo.modifyMemberIsvalid(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.trashMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward restoreMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        MemberBo bo = new MemberBo();
        Member member = new Member();
        member.setId(Integer.valueOf(id));
        member.setIsvalid(1);
        bo.modifyMemberIsvalid(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.restoreMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        smb.setQueryData("istrash", "1");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward removeMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        MemberBo bo = new MemberBo();
        bo.removeMember(Integer.valueOf(id));

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.removeMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        smb.setQueryData("istrash", "1");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward resetMemberPwd(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        Member member = new Member();
        member.setId(Integer.valueOf(id));
        MemberBo bo = new MemberBo();
        bo.resetMemberPwd(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.resetMemberPwd.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward auditMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        Member member = new Member();
        member.setId(Integer.valueOf(id));
        member.setState(1);
        MemberBo bo = new MemberBo();
        bo.lockMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.auditMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward lockMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        Member member = new Member();
        member.setId(Integer.valueOf(id));
        member.setState(2);
        MemberBo bo = new MemberBo();
        bo.lockMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.lockMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward unLockMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        String id = request.getParameter("id");
        Member member = new Member();
        member.setId(Integer.valueOf(id));
        member.setState(1);
        MemberBo bo = new MemberBo();
        bo.lockMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.unLockMember.success"));
        smb.setLinkText(new ActionMessage("manage.MemberAction.return"));
        smb.setAction("/load4MemberIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward load4MemberPwdModify(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward modifyMemberPwd(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        String id = sessionMap.get("memberid");
        MemberBo bo = new MemberBo();
        MemberForm memberForm = (MemberForm) form;
        Member member = memberForm.getMember();
        member.setId(Integer.valueOf(id));
        String password_old = member.getPassword_old();
        String password = member.getPassword();
        String password_re = member.getPassword_re();
        Member memberDB = bo.getMember(member.getId());
        String passwordDB = memberDB.getPassword();
        if (!DigestUtils.md5Hex(password_old).equals(passwordDB)) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage(
                    "MemberAction.modifyMemberPwd.wrong"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        if (!password.equals(password_re)) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage(
                    "MemberAction.modifyMemberPwd.password"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        bo.modifyMemberPwd(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "MemberAction.modifyMemberPwd.success", member.getFactname()));
        smb.setAction("/load4MemberPwdModify");
        smb.setLinkText(new ActionMessage(
                "MemberAction.modifyMemberPwd.returnModify"));
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

}