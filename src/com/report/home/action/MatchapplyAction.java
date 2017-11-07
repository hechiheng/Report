package com.report.home.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.manage.bean.Matchapply;
import com.report.manage.bean.Matchinfo;
import com.report.manage.bo.MatchapplyBo;
import com.report.manage.form.MatchapplyForm;

public class MatchapplyAction extends BaseAction {

    @SuppressWarnings("unchecked")
    public ActionForward load4MatchapplyIndex(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.HOME_SESSION);
        int memberid = Integer.valueOf(sessionMap.get("memberid"));
        Matchapply matchapply = new Matchapply();
        matchapply.setMemberid(memberid);
        MatchapplyBo bo = new MatchapplyBo();
        List<Matchapply> matchapplyList = bo.getMatchapplyList4Home(matchapply);
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

    @SuppressWarnings("unchecked")
    public ActionForward addMatchapply(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.HOME_SESSION);
        int memberid = Integer.valueOf(sessionMap.get("memberid"));
        MatchapplyBo bo = new MatchapplyBo();
        MatchapplyForm matchapplyForm = (MatchapplyForm) form;
        Matchapply matchapply = matchapplyForm.getMatchapply();
        HttpSession session = request.getSession(false);
        String imagecode = (String) session.getAttribute("imagecode");
        if (!imagecode.equals(matchapply.getImagecode())) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage("error.input.imagecode"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        matchapply.setMemberid(memberid);
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
    
    public ActionForward load4Matchresult(ActionMapping mapping,
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
        if (matchapply.getState() > 1) {
            SysMessageBean smb = new SysMessageBean(false);
            smb.setMessage(new ActionMessage("error.exception"));
            smb.setLinkText(new ActionMessage("MatchapplyAction.return"));
            smb.setAction("/load4MatchapplyIndex");
            SysGlobals.setSysMessage(request, smb);
            return mapping.findForward("info");
        }

        List<Matchinfo> matchinfoList = bo.getMatchinfoList();
        request.setAttribute("matchinfoList", matchinfoList);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward modifyMatchapply(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.HOME_SESSION);
        int memberid = Integer.valueOf(sessionMap.get("memberid"));
        MatchapplyBo bo = new MatchapplyBo();
        MatchapplyForm matchapplyForm = (MatchapplyForm) form;
        Matchapply matchapply = matchapplyForm.getMatchapply();
        HttpSession session = request.getSession(false);
        String imagecode = (String) session.getAttribute("imagecode");
        if (!imagecode.equals(matchapply.getImagecode())) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage("error.input.imagecode"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        matchapply.setMemberid(memberid);
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

    @SuppressWarnings("unchecked")
    public ActionForward load4MatchresultIndex(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.HOME_SESSION);
        int memberid = Integer.valueOf(sessionMap.get("memberid"));
        Matchapply matchapply = new Matchapply();
        matchapply.setMemberid(memberid);
        MatchapplyBo bo = new MatchapplyBo();
        List<Matchapply> matchapplyList = bo
                .getMatchresultList4Home(matchapply);
        request.setAttribute("matchapplyList", matchapplyList);
        return mapping.findForward("success");
    }

}