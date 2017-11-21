package com.report.home.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.home.bean.About;
import com.report.home.bean.Announce;
import com.report.home.bean.Link;
import com.report.home.bean.Message;
import com.report.home.bean.News;
import com.report.home.bean.Notice;
import com.report.home.bo.HomeBo;
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

        About about = bo.getAbout(2);
        request.setAttribute("about", about);
        return mapping.findForward("success");
    }

    public ActionForward load4Admin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
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

        About about = bo.getAbout(1);
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

        About about = bo.getAbout(1);
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

        About about = bo.getAbout(1);
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

        About about = bo.getAbout(1);
        request.setAttribute("about", about);
        return mapping.findForward("success");
    }

    public ActionForward load4About(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        HomeBo bo = new HomeBo();
        About about = bo.getAbout(1);
        request.setAttribute("about", about);

        Announce announce = bo.getLatestAnnounce();
        request.setAttribute("announce", announce);
        return mapping.findForward("success");
    }

    public ActionForward load4WebAbout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        HomeBo bo = new HomeBo();
        About about = bo.getAbout(2);
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

        About about = bo.getAbout(1);
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

        About about = bo.getAbout(1);
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