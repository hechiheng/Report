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
import com.report.home.bean.Message;
import com.report.manage.bo.MessageBo;
import com.report.manage.form.MessageForm;
import com.report.utils.Page;

public class MessageAction extends BaseAction {

	public ActionForward load4MessageIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		MessageForm messageForm = (MessageForm) form;
		Message message = messageForm.getMessage();
		String istrash = request.getParameter("istrash");
		String title = message.getTitle();
		String p = request.getParameter("p");
		MessageBo bo = new MessageBo();
		message.setIsvalid("1".equals(istrash) ? 0 : 1);
		int total = bo.getMessageListSize(message);
		Page page = new Page(total, p, message, "load4MessageIndex");
		page.setQueryData("istrash", istrash == null ? "" : istrash);
		page.setQueryData("message.title", title == null ? "" : title);
		List<Message> messageList = bo.getMessageList(message);
		request.setAttribute("messageList", messageList);
		request.setAttribute("page", page);
		request.setAttribute("istrash", istrash);
		return mapping.findForward("success");
	}

	public ActionForward load4MessageAdd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward addMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		MessageBo bo = new MessageBo();
		MessageForm messageForm = (MessageForm) form;
		Message message = messageForm.getMessage();
		message.setUserid(userid);
		bo.addMessage(message);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MessageAction.addMessage.success"));
		smb.setLinkText(new ActionMessage("MessageAction.return"));
		smb.setAction("/load4MessageIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4MessageModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MessageForm messageForm = (MessageForm) form;
		MessageBo bo = new MessageBo();
		Message message = bo.getMessage(Integer.valueOf(id));
		messageForm.setMessage(message);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward modifyMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		MessageBo bo = new MessageBo();
		MessageForm messageForm = (MessageForm) form;
		Message message = messageForm.getMessage();
		message.setUserid(userid);
		bo.modifyMessage(message);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"MessageAction.modifyMessage.success"));
		smb.setLinkText(new ActionMessage("MessageAction.return"));
		smb.setAction("/load4MessageIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward trashMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		MessageBo bo = new MessageBo();
		Message message = new Message();
		message.setId(Integer.valueOf(id));
		message.setUserid(userid);
		message.setIsvalid(0);
		bo.modifyMessageIsvalid(message);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MessageAction.trashMessage.success"));
		smb.setLinkText(new ActionMessage("MessageAction.return"));
		smb.setAction("/load4MessageIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward restoreMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		MessageBo bo = new MessageBo();
		Message message = new Message();
		message.setId(Integer.valueOf(id));
		message.setUserid(userid);
		message.setIsvalid(1);
		bo.modifyMessageIsvalid(message);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"MessageAction.restoreMessage.success"));
		smb.setLinkText(new ActionMessage("MessageAction.return"));
		smb.setAction("/load4MessageIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		MessageBo bo = new MessageBo();
		bo.removeMessage(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"MessageAction.removeMessage.success"));
		smb.setLinkText(new ActionMessage("MessageAction.return"));
		smb.setAction("/load4MessageIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}