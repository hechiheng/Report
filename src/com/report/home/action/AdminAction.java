package com.report.home.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.css.base.BaseAction;
import com.css.base.BaseException;

public class AdminAction extends BaseAction {

    public ActionForward load4Admin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        return mapping.findForward("success");
    }

}