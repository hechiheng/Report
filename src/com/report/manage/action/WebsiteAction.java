package com.report.manage.action;

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
import com.report.manage.bean.Website;
import com.report.manage.bo.WebsiteBo;
import com.report.manage.form.WebsiteForm;

public class WebsiteAction extends BaseAction {

	public ActionForward load4WebsiteModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		WebsiteForm websiteForm = (WebsiteForm) form;
		WebsiteBo bo = new WebsiteBo();
		Website website = bo.getWebsite();
		websiteForm.setWebsite(website);
		return mapping.findForward("success");
	}

	public ActionForward modifyWebsite(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		WebsiteBo bo = new WebsiteBo();
		WebsiteForm websiteForm = (WebsiteForm) form;
		Website website = websiteForm.getWebsite();
		bo.modifyWebsite(website);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"WebsiteAction.modifyWebsite.success"));
		smb
				.setLinkText(new ActionMessage(
						"WebsiteAction.modifyWebsite.return"));
		smb.setAction("/load4WebsiteModify");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}