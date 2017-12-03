package com.report.manage.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.DynaValidatorForm;
import org.apache.struts.validator.Resources;

import com.css.base.BaseAction;
import com.css.base.BaseException;
import com.report.global.Constants;
import com.report.global.SysGlobals;
import com.report.global.SysMessageBean;
import com.report.home.bean.Announce;
import com.report.home.bean.Member;
import com.report.home.bean.Message;
import com.report.manage.bean.Menu;
import com.report.manage.bean.User;
import com.report.manage.bo.AnnounceBo;
import com.report.manage.bo.LoginBo;
import com.report.manage.bo.MemberBo;
import com.report.manage.bo.MessageBo;
import com.report.manage.form.MemberForm;
import com.report.utils.CheckCodeImage;

public class LoginAction extends BaseAction {

    public ActionForward load4Login(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        return mapping.findForward("success");
    }

    public ActionForward load4MemberReg(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        return mapping.findForward("success");
    }

    public ActionForward login(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        LoginBo bo = new LoginBo();
        DynaValidatorForm loginForm = (DynaValidatorForm) form;
        String username = loginForm.getString("username");
        String password = loginForm.getString("password");
        String imagecode = loginForm.getString("imagecode");
        String logintype = loginForm.getString("logintype");
        String flag = "index";
        HttpSession session = request.getSession(false);
        session.removeAttribute("username");

        if (!imagecode.equals(session.getAttribute("imagecode"))) {
            flag = "failure";
            ActionMessages msg = new ActionMessages();
            msg.add("sysMessage", new ActionMessage("error.input.imagecode"));
            saveErrors(request, msg);
        }
        else if (StringUtils.isEmpty(logintype)) {
            flag = "failure";
            ActionMessages msg = new ActionMessages();
            msg.add("sysMessage", new ActionMessage("error.input.usertype"));
            saveErrors(request, msg);
        }
        else {
            try {
                if ("1".equals(logintype)) {
                    Member member = new Member();
                    member.setAccountid(username);
                    member.setPassword(password);

                    Member memberDB = bo.getMemberInfo(member);
                    if (memberDB != null) {
                        if (memberDB.getState() == 0) {
                            SysMessageBean smb = new SysMessageBean(true);
                            smb.setMessage(new ActionMessage(
                                    "LoginAction.login.notaudit"));
                            smb.setLinkText(new ActionMessage(
                                    "LoginAction.login.return"));
                            smb.setAction("/load4Login");
                            smb.setLinkTarget("_parent");
                            SysGlobals.setSysMessage(request, smb);
                            return mapping.findForward("error");
                        }
                        else if (memberDB.getState() == 2) {
                            SysMessageBean smb = new SysMessageBean(true);
                            smb.setMessage(new ActionMessage(
                                    "LoginAction.login.lock"));
                            smb.setLinkText(new ActionMessage(
                                    "LoginAction.login.return"));
                            smb.setAction("/index");
                            smb.setLinkTarget("_parent");
                            SysGlobals.setSysMessage(request, smb);
                            return mapping.findForward("error");
                        }

                        Map<String, String> sessionMap = new HashMap<String, String>();
                        sessionMap.put("memberid", String.valueOf(memberDB
                                .getId()));
                        sessionMap.put("accountid", memberDB.getAccountid());
                        sessionMap.put("factname", memberDB.getFactname());
                        SysGlobals.setSessionObj(request,
                                Constants.MANAGE_SESSION, sessionMap);
                        flag = "indexMember";
                    }
                    else {
                        ActionMessages msg = new ActionMessages();
                        msg.add("sysMessage", new ActionMessage(
                                "LoginAction.login.failed"));
                        saveErrors(request, msg);
                        flag = "failure";
                    }
                }
                else if ("2".equals(logintype)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);

                    User userDB = bo.getUserInfo(user);
                    if (userDB != null) {
                        Map<String, String> sessionMap = new HashMap<String, String>();
                        sessionMap
                                .put("userid", String.valueOf(userDB.getId()));
                        sessionMap.put("username", userDB.getUsername());
                        sessionMap.put("factname", userDB.getFactname());
                        sessionMap.put("usertype", String.valueOf(userDB
                                .getUsertype()));
                        SysGlobals.setSessionObj(request,
                                Constants.MANAGE_SESSION, sessionMap);
                    }
                    else {
                        ActionMessages msg = new ActionMessages();
                        msg.add("sysMessage", new ActionMessage(
                                "LoginAction.login.failed"));
                        saveErrors(request, msg);
                        flag = "failure";
                    }
                }
                else {
                    flag = "failure";
                    ActionMessages msg = new ActionMessages();
                    msg.add("sysMessage", new ActionMessage(
                            "error.input.logintype"));
                    saveErrors(request, msg);
                }
            }
            catch (BaseException e) {
                throw new BaseException("errors.not.connect.db", e);
            }
        }
        return mapping.findForward(flag);
    }

    public ActionForward logout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        SysGlobals.removeSessionObj(request, Constants.MANAGE_SESSION);
        return mapping.findForward("success");
    }

    @SuppressWarnings("unchecked")
    public ActionForward load4Index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        Map<String, String> sessionMap = SysGlobals.getSessionObj(request,
                Constants.MANAGE_SESSION);
        int userid = Integer.valueOf(sessionMap.get("userid"));
        LoginBo bo = new LoginBo();
        List<Menu> menuList = bo.getMenuList(userid);
        request.setAttribute("menuList", menuList);
        return mapping.findForward("success");
    }

    public ActionForward load4IndexMember(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        return mapping.findForward("success");
    }

    public ActionForward load4Right(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        AnnounceBo announceBo = new AnnounceBo();
        List<Announce> announceList = announceBo.getLatestAnnounceList();
        request.setAttribute("announceList", announceList);

        MessageBo messageBo = new MessageBo();
        List<Message> messageList = messageBo.getLatestMessageList();
        request.setAttribute("messageList", messageList);
        return mapping.findForward("success");
    }

    public ActionForward imageCode(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {

        CheckCodeImage cci = new CheckCodeImage(CheckCodeImage.NUM);
        HttpSession session = request.getSession(false);
        try {
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            ImageIO.write(cci.getImage(), "PNG", os);
            session.setAttribute("imagecode", cci.getRandCode());
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new BaseException("LoginAction.imageCheck");
        }
        return null;
    }

    public ActionForward verifyMemberReg(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException, IOException {
        String accountid = request.getParameter("accountid");
        MemberBo bo = new MemberBo();
        String key = bo.verifyMember(accountid);
        if (!key.equals("")) {
            MessageResources resource = Resources.getMessageResources(request);
            String msg = resource.getMessage(key);
            response.getWriter().println(msg);
        }

        return null;
    }

    public ActionForward regMember(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws BaseException {
        MemberBo bo = new MemberBo();
        MemberForm memberForm = (MemberForm) form;
        Member member = memberForm.getMember();
        int cnt = bo.getMemberCount(member.getAccountid());
        if (cnt > 0) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage(
                    "manage.MemberAction.addMember.accountidExists"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }
        if (!member.getPassword().equals(member.getPassword_re())) {
            ActionMessages am = new ActionMessages();
            am.add("sysMessage", new ActionMessage(
                    "manage.MemberAction.addMember.password"));
            saveErrors(request, am);
            return mapping.findForward("failure");
        }

        bo.addMember(member);

        SysMessageBean smb = new SysMessageBean(false);
        smb.setMessage(new ActionMessage(
                "manage.MemberAction.addMember.success"));
        smb.setLinkText(new ActionMessage("MemberAction.regMember.returnLogin"));
        smb.setAction("/load4Login");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

}