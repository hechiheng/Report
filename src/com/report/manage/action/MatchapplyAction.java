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
import com.report.manage.bean.Matchapply;
import com.report.manage.bo.MatchapplyBo;
import com.report.manage.form.MatchapplyForm;
import com.report.utils.Page;

public class MatchapplyAction extends BaseAction {

    public ActionForward load4MatchapplyIndex(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        MatchapplyForm matchapplyForm = (MatchapplyForm) form;
        Matchapply matchapply = matchapplyForm.getMatchapply();
        String name = matchapply.getName();
        String p = request.getParameter("p");
        MatchapplyBo bo = new MatchapplyBo();
        int total = bo.getMatchapplyList1Size(matchapply);
        Page page = new Page(total, p, matchapply, "load4MatchapplyIndex");
        page.setQueryData("matchapply.name", name == null ? "" : name);
        List<Matchapply> matchapplyList = bo.getMatchapplyList1(matchapply);
        request.setAttribute("matchapplyList", matchapplyList);
        request.setAttribute("page", page);
        return mapping.findForward("success");
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

    public ActionForward load4MatchapplyAudit(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        String id = request.getParameter("id");
        MatchapplyBo bo = new MatchapplyBo();
        Matchapply matchapply = bo.getMatchapply(Integer.valueOf(id));
        request.setAttribute("matchapply", matchapply);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward auditMatchapply(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        int userid = Integer.valueOf(sessionMap.get("userid"));
        String id = request.getParameter("id");
        String state = request.getParameter("state");
        Matchapply matchapply = new Matchapply();
        matchapply.setId(Integer.valueOf(id));
        matchapply.setState(Integer.valueOf(state));
        MatchapplyBo bo = new MatchapplyBo();
        matchapply.setCheckuserid(userid);
        bo.auditMatchapply(matchapply);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "MatchapplyAction.auditMatchapply.success"));
        smb.setLinkText(new ActionMessage("MatchapplyAction.return"));
        smb.setAction("/load4MatchapplyIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward load4MatchresultModify(ActionMapping mapping,
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
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward modifyMatchresult(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        int userid = Integer.valueOf(sessionMap.get("userid"));
        MatchapplyForm matchapplyForm = (MatchapplyForm) form;
        Matchapply matchapply = matchapplyForm.getMatchapply();
        MatchapplyBo bo = new MatchapplyBo();
        matchapply.setResultuserid(userid);
        if (bo.getMatchresultCount(matchapply) == 0) {
            bo.addMatchresult(matchapply);
        }
        else {
            bo.modifyMatchresult(matchapply);
        }

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "MatchapplyAction.modifyMatchresult.success"));
        smb.setLinkText(new ActionMessage("MatchapplyAction.return"));
        smb.setAction("/load4MatchapplyIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }
}