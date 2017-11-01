package com.report.home.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.home.bean.About;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;
import com.report.home.bean.Notice;
import com.report.home.bo.HomeBo;
import com.report.manage.bean.Website;
import com.report.utils.Page;

public class HomeAction extends BaseAction {

	public ActionForward load4Home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HomeBo bo = new HomeBo();
		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		List<Message> messageList = bo.getLatestMessageList();
		request.setAttribute("messageList", messageList);

		List<News> newsList = bo.getLatestNewsList();
		request.setAttribute("newsList", newsList);

		List<Link> linkList = bo.getLinkList();
		request.setAttribute("linkList", linkList);

		Map map_global = SysGlobals.getSessionObj(request,
				Constants.GLOBAL_SESSION);
		if (map_global == null) {
			Website website = bo.getWebsite();
			Map<String, String> sessionMap = new HashMap<String, String>();
			sessionMap.put("cfg_webname", website.getCfg_webname());
			sessionMap.put("cfg_webtitle", website.getCfg_webtitle());
			sessionMap.put("cfg_themestyle", website.getCfg_themestyle());
			sessionMap.put("cfg_keywords", website.getCfg_keywords());
			sessionMap.put("cfg_description", website.getCfg_description());
			sessionMap.put("cfg_powerby", website.getCfg_powerby());
			sessionMap.put("cfg_recordno", website.getCfg_recordno());
			sessionMap.put("cfg_address", website.getCfg_address());
			sessionMap.put("cfg_phone", website.getCfg_phone());
			sessionMap.put("cfg_qq", website.getCfg_qq());
			sessionMap.put("cfg_email", website.getCfg_email());
			sessionMap.put("cfg_website_close", String.valueOf(website
					.getCfg_website_close()));
			sessionMap.put("cfg_website_close_info", website
					.getCfg_website_close_info());
			SysGlobals.setSessionObj(request, Constants.GLOBAL_SESSION,
					sessionMap);
		}
		return mapping.findForward("success");
	}

	public ActionForward load4Admin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		SysGlobals.removeSessionObj(request, Constants.HOME_SESSION);
		return mapping.findForward("success");
	}

	public ActionForward showMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		HomeBo bo = new HomeBo();
		Message message = bo.getMessage(Integer.valueOf(id));
		request.setAttribute("message", message);

		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		About about = bo.getAbout();
		request.setAttribute("about", about);
		return mapping.findForward("success");
	}

	public ActionForward load4Message(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String p = request.getParameter("p");
		Message message = new Message();
		HomeBo bo = new HomeBo();
		int total = bo.getMessageListSize();
		Page page = new Page(total, p, message, "load4Message.do");
		List<Message> messageList = bo.getMessageList(message);
		request.setAttribute("messageList", messageList);
		request.setAttribute("page", page);

		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		About about = bo.getAbout();
		request.setAttribute("about", about);
		return mapping.findForward("success");
	}

	public ActionForward showNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		HomeBo bo = new HomeBo();
		News news = bo.getNews(Integer.valueOf(id));
		request.setAttribute("news", news);

		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		About about = bo.getAbout();
		request.setAttribute("about", about);
		return mapping.findForward("success");
	}

	public ActionForward load4News(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String p = request.getParameter("p");
		News news = new News();
		HomeBo bo = new HomeBo();
		int total = bo.getNewsListSize();
		Page page = new Page(total, p, news, "load4News.do");
		List<News> newsList = bo.getNewsList(news);
		request.setAttribute("newsList", newsList);
		request.setAttribute("page", page);

		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		About about = bo.getAbout();
		request.setAttribute("about", about);
		return mapping.findForward("success");
	}

	public ActionForward load4About(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HomeBo bo = new HomeBo();
		About about = bo.getAbout();
		request.setAttribute("about", about);

		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);
		return mapping.findForward("success");
	}

	public ActionForward load4LatestAnnounce(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		HomeBo bo = new HomeBo();
		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);

		About about = bo.getAbout();
		request.setAttribute("about", about);
		return mapping.findForward("success");
	}

	public ActionForward showAnnounce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		HomeBo bo = new HomeBo();
		Announce announce = bo.getAnnounce(Integer.valueOf(id));
		request.setAttribute("announce", announce);

		About about = bo.getAbout();
		request.setAttribute("about", about);
		return mapping.findForward("success");
	}

	public ActionForward load4Notice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HomeBo bo = new HomeBo();
		Notice notice = bo.getNotice();
		request.setAttribute("notice", notice);

		Announce announce = bo.getLatestAnnounce();
		request.setAttribute("announce", announce);
		return mapping.findForward("success");
	}

}