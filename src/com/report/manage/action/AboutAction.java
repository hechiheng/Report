package com.report.manage.action;

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
import com.report.home.bean.About;
import com.report.manage.bo.AboutBo;
import com.report.manage.form.AboutForm;

public class AboutAction extends BaseAction {

    public ActionForward load4AboutModify(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        AboutForm aboutForm = (AboutForm) form;
        AboutBo bo = new AboutBo();
        About about = bo.getAbout(1);
        aboutForm.setAbout(about);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward modifyAbout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        int userid = Integer.valueOf(sessionMap.get("userid"));
        AboutBo bo = new AboutBo();
        AboutForm aboutForm = (AboutForm) form;
        About about = aboutForm.getAbout();
        about.setUserid(userid);
        about.setId(1);
        bo.modifyAbout(about);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage("AboutAction.modifyAbout.success"));
        smb.setLinkText(new ActionMessage("AboutAction.modifyAbout.return"));
        smb.setAction("/load4AboutModify");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward load4WebAboutModify(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        AboutForm aboutForm = (AboutForm) form;
        AboutBo bo = new AboutBo();
        About about = bo.getAbout(2);
        aboutForm.setAbout(about);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward modifyWebAbout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        int userid = Integer.valueOf(sessionMap.get("userid"));
        AboutBo bo = new AboutBo();
        AboutForm aboutForm = (AboutForm) form;
        About about = aboutForm.getAbout();
        about.setUserid(userid);
        about.setId(2);
        bo.modifyAbout(about);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage("AboutAction.modifyAbout.success"));
        smb.setLinkText(new ActionMessage("AboutAction.modifyAbout.return"));
        smb.setAction("/load4WebAboutModify");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

}