package com.report.manage.action;

import java.util.List;

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
import com.report.manage.bean.Menu;
import com.report.manage.bo.MenuBo;
import com.report.manage.form.MenuForm;

public class MenuAction extends BaseAction {

	public ActionForward load4MenuIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MenuForm menuForm = (MenuForm) form;
		Menu menu = menuForm.getMenu();
		MenuBo bo = new MenuBo();
		List<Menu> menuList = bo.getAllMenuList(menu);
		request.setAttribute("menuList", menuList);
		return mapping.findForward("success");
	}

	public ActionForward load4MenuAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String pid = request.getParameter("pid");
		MenuForm menuForm = (MenuForm) form;
		Menu menu = menuForm.getMenu();
		menu.setPid(pid == null ? 0 : Integer.valueOf(pid));
		MenuBo bo = new MenuBo();
		List<Menu> menuList = bo.getTopMenuList(null);
		request.setAttribute("menuList", menuList);
		return mapping.findForward("success");
	}

	public ActionForward addMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MenuBo bo = new MenuBo();
		MenuForm menuForm = (MenuForm) form;
		Menu menu = menuForm.getMenu();
		bo.addMenu(menu);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MenuAction.addMenu.success"));
		smb.setLinkText(new ActionMessage("MenuAction.return"));
		smb.setAction("/load4MenuIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4MenuModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		MenuForm menuForm = (MenuForm) form;
		MenuBo bo = new MenuBo();
		Menu menu = bo.getMenu(Integer.valueOf(id));
		menuForm.setMenu(menu);

		List<Menu> menuList = bo.getTopMenuList(null);
		request.setAttribute("menuList", menuList);
		return mapping.findForward("success");
	}

	public ActionForward modifyMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		MenuBo bo = new MenuBo();
		MenuForm menuForm = (MenuForm) form;
		Menu menu = menuForm.getMenu();
		bo.modifyMenu(menu);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MenuAction.modifyMenu.success"));
		smb.setLinkText(new ActionMessage("MenuAction.return"));
		smb.setAction("/load4MenuIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward trashMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		MenuBo bo = new MenuBo();
		Menu menu = new Menu();
		menu.setId(Integer.valueOf(id));
		menu.setPid(Integer.valueOf(pid));
		menu.setIsvalid(0);
		if (id == null || pid == null) {
			SysMessageBean smb = new SysMessageBean(true);
			smb.setMessage(new ActionMessage("MenuAction.trashMenu.failure"));
			smb.setLinkText(new ActionMessage("MenuAction.return"));
			smb.setAction("/load4MenuIndex");
			SysGlobals.setSysMessage(request, smb);
			return mapping.findForward("error");
		} else if (menu.getPid() == 0 && !bo.getSubMenuList(menu).isEmpty()) {
			SysMessageBean smb = new SysMessageBean(true);
			smb.setMessage(new ActionMessage(
					"MenuAction.trashMenu.hasChildMenu"));
			smb.setLinkText(new ActionMessage("MenuAction.trashMenu.return"));
			smb.setAction("/load4MenuIndex");
			SysGlobals.setSysMessage(request, smb);
			return mapping.findForward("error");
		}

		bo.modifyMenuIsvalid(menu);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("MenuAction.trashMenu.success"));
		smb.setLinkText(new ActionMessage("MenuAction.return"));
		smb.setAction("/load4MenuIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}