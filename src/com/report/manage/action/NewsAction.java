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
import com.report.home.bean.News;
import com.report.manage.bo.NewsBo;
import com.report.manage.form.NewsForm;
import com.report.utils.Page;

public class NewsAction extends BaseAction {

	public ActionForward load4NewsIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		NewsForm newsForm = (NewsForm) form;
		News news = newsForm.getNews();
		String istrash = request.getParameter("istrash");
		String title = news.getTitle();
		String p = request.getParameter("p");
		NewsBo bo = new NewsBo();
		news.setIsvalid("1".equals(istrash) ? 0 : 1);
		int total = bo.getNewsListSize(news);
		Page page = new Page(total, p, news, "load4NewsIndex");
		page.setQueryData("istrash", istrash == null ? "" : istrash);
		page.setQueryData("news.title", title == null ? "" : title);
		List<News> newsList = bo.getNewsList(news);
		request.setAttribute("newsList", newsList);
		request.setAttribute("page", page);
		request.setAttribute("istrash", istrash);
		return mapping.findForward("success");
	}

	public ActionForward load4NewsAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward addNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		NewsBo bo = new NewsBo();
		NewsForm newsForm = (NewsForm) form;
		News news = newsForm.getNews();
		news.setUserid(userid);
		bo.addNews(news);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("NewsAction.addNews.success"));
		smb.setLinkText(new ActionMessage("NewsAction.addNews.return"));
		smb.setAction("/load4NewsIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4NewsModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		NewsForm newsForm = (NewsForm) form;
		NewsBo bo = new NewsBo();
		News news = bo.getNews(Integer.valueOf(id));
		newsForm.setNews(news);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward modifyNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		NewsBo bo = new NewsBo();
		NewsForm newsForm = (NewsForm) form;
		News news = newsForm.getNews();
		news.setUserid(userid);
		bo.modifyNews(news);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("NewsAction.modifyNews.success"));
		smb.setLinkText(new ActionMessage("NewsAction.modifyNews.return"));
		smb.setAction("/load4NewsIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward trashNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		NewsBo bo = new NewsBo();
		News news = new News();
		news.setId(Integer.valueOf(id));
		news.setUserid(userid);
		news.setIsvalid(0);
		bo.modifyNewsIsvalid(news);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("NewsAction.trashNews.success"));
		smb.setLinkText(new ActionMessage("NewsAction.trashNews.return"));
		smb.setAction("/load4NewsIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	@SuppressWarnings("unchecked")
	public ActionForward restoreNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
				Constants.MANAGE_SESSION);
		int userid = Integer.valueOf(sessionMap.get("userid"));
		NewsBo bo = new NewsBo();
		News news = new News();
		news.setId(Integer.valueOf(id));
		news.setUserid(userid);
		news.setIsvalid(1);
		bo.modifyNewsIsvalid(news);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("NewsAction.restoreNews.success"));
		smb.setLinkText(new ActionMessage("NewsAction.restoreNews.return"));
		smb.setAction("/load4NewsIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		NewsBo bo = new NewsBo();
		bo.removeNews(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("NewsAction.removeNews.success"));
		smb.setLinkText(new ActionMessage("NewsAction.removeNews.return"));
		smb.setAction("/load4NewsIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}