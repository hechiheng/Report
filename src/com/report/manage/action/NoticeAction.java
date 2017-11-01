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
import com.report.home.bean.Notice;
import com.report.manage.bo.NoticeBo;
import com.report.manage.form.NoticeForm;

public class NoticeAction extends BaseAction {

	public ActionForward load4NoticeModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		NoticeForm noticeForm = (NoticeForm) form;
		NoticeBo bo = new NoticeBo();
		Notice notice = bo.getNotice();
		noticeForm.setNotice(notice);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward modifyNotice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		NoticeBo bo = new NoticeBo();
		NoticeForm noticeForm = (NoticeForm) form;
		Notice notice = noticeForm.getNotice();
		notice.setUserid(userid);
		bo.addNotice(notice);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("NoticeAction.modifyNotice.success"));
		smb.setLinkText(new ActionMessage("NoticeAction.modifyNotice.return"));
		smb.setAction("/load4NoticeModify");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}