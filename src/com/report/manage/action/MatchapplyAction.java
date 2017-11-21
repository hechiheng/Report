package com.report.manage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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
import com.report.manage.bean.Matchinfo;
import com.report.manage.bo.MatchapplyBo;
import com.report.manage.form.MatchapplyForm;
import com.report.utils.Page;

public class MatchapplyAction extends BaseAction {
    private Logger logger = Logger.getLogger("MatchapplyAction");

    public ActionForward load4MatchapplyIndex(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        MatchapplyForm matchapplyForm = (MatchapplyForm) form;
        Matchapply matchapply = matchapplyForm.getMatchapply();
        String name = matchapply.getName();
        String factname = matchapply.getFactname();
        int matchid = matchapply.getMatchid();
        int state = matchapply.getState();
        String annualmatch = matchapply.getAnnualmatch();
        String p = request.getParameter("p");
        MatchapplyBo bo = new MatchapplyBo();
        int total = bo.getMatchapplyListSize(matchapply);
        Page page = new Page(total, p, matchapply, "load4MatchapplyIndex");
        page.setQueryData("matchapply.name", name == null ? "" : name);
        page.setQueryData("matchapply.factname", factname == null ? ""
                : factname);
        page.setQueryData("matchapply.matchid", matchid == 0 ? "" : matchid
                + "");
        page.setQueryData("matchapply.state", state == 0 ? "" : state + "");
        page.setQueryData("matchapply.annualmatch", annualmatch == null ? ""
                : annualmatch);
        List<Matchinfo> matchinfoList = bo.getMatchinfoList();
        request.setAttribute("matchinfoList", matchinfoList);

        List<Matchapply> matchapplyList = bo.getMatchapplyList(matchapply);
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

    public ActionForward load4MatchresultIndex(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        MatchapplyForm matchapplyForm = (MatchapplyForm) form;
        Matchapply matchapply = matchapplyForm.getMatchapply();
        String name = matchapply.getName();
        String p = request.getParameter("p");
        MatchapplyBo bo = new MatchapplyBo();
        int total = bo.getMatchresultListSize(matchapply);
        Page page = new Page(total, p, matchapply, "load4MatchresultIndex");
        page.setQueryData("matchapply.name", name == null ? "" : name);
        List<Matchapply> matchapplyList = bo.getMatchresultList(matchapply);
        request.setAttribute("matchapplyList", matchapplyList);
        request.setAttribute("page", page);
        return mapping.findForward("success");
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
        smb.setAction("/load4MatchresultIndex");
        SysGlobals.setSysMessage(request, smb);
        return mapping.findForward("info");
    }

    public ActionForward exportMatchapplyFiles(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws BaseException {
        String annualmatch = request.getParameter("annualmatch");
        String factname = request.getParameter("factname");
        String ids = request.getParameter("ids");
        if (StringUtils.isEmpty(annualmatch)) {
            SysMessageBean smb = new SysMessageBean(true);
            smb.setMessage(new ActionMessage(
                    "MatchapplyAction.exportMatchapplyFiles.annualmatch"));
            SysGlobals.setSysMessage(request, smb);
            return mapping.findForward("error");
        }
        if (StringUtils.isEmpty(factname)) {
            SysMessageBean smb = new SysMessageBean(true);
            smb.setMessage(new ActionMessage(
                    "MatchapplyAction.exportMatchapplyFiles.factname"));
            SysGlobals.setSysMessage(request, smb);
            return mapping.findForward("error");
        }
        if (StringUtils.isEmpty(ids)) {
            SysMessageBean smb = new SysMessageBean(true);
            smb.setMessage(new ActionMessage(
                    "MatchapplyAction.exportMatchapplyFiles.noselect"));
            SysGlobals.setSysMessage(request, smb);
            return mapping.findForward("error");
        }
        String rootPath = this.getServlet().getServletContext()
                .getRealPath("/");
        String filePath = SysGlobals.getSysConfig("filePath");
        // String zipName = System.currentTimeMillis() + ".zip";
        String zipName = annualmatch + "_" + factname + ".zip";
        String zipPath = rootPath + filePath + zipName;
        File zipFile = new File(zipPath);

        MatchapplyBo bo = new MatchapplyBo();
        List<Matchapply> matchapplyList = bo.getMatchapplyFileList(ids);
        List<File> fileList = new ArrayList<File>();
        for (Matchapply matchapply : matchapplyList) {
            File file = new File(matchapply.getPhysicalpath());
            fileList.add(file);
        }

        ZipArchiveOutputStream zos = null;
        FileInputStream fis = null;
        try {
            zos = new ZipArchiveOutputStream(zipFile);
            for (int i = 0; i < matchapplyList.size(); i++) {
                ZipArchiveEntry zipEntry = new ZipArchiveEntry(matchapplyList
                        .get(i).getFilename());
                zos.putArchiveEntry(zipEntry);
                fis = new FileInputStream(fileList.get(i));
                byte[] b = new byte[1024];
                int n = 0;
                while ((n = fis.read(b)) > 0) {
                    zos.write(b, 0, n);
                }
            }
            zos.closeArchiveEntry();
            zos.close();
            fis.close();

            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename="
                    + java.net.URLEncoder.encode(zipName, "UTF-8"));

            OutputStream out = response.getOutputStream();
            FileInputStream fisZip = new FileInputStream(zipPath);
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = fisZip.read(b)) > 0) {
                out.write(b, 0, i);
            }
            out.flush();
            fisZip.close();
            out.close();
        }
        catch (Exception e) {
            logger.error("manage.MatchapplyAction.exportMatchapplyFiles", e);

            response.reset();
            SysMessageBean smb = new SysMessageBean(true);
            smb.setMessage(new ActionMessage(
                    "MatchapplyAction.exportMatchapplyFiles.error"));
            SysGlobals.setSysMessage(request, smb);
            return mapping.findForward("error");
        }
        finally {
            if (zipFile.exists()) {
                zipFile.delete();
            }
        }

        return null;
    }
}