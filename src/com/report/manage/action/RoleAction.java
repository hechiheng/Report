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
import com.report.manage.bean.Role;
import com.report.manage.bo.RoleBo;
import com.report.manage.form.RoleForm;
import com.report.utils.Page;

public class RoleAction extends BaseAction {

	public ActionForward load4RoleIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		RoleForm roleForm = (RoleForm) form;
		Role role = roleForm.getRole();
		String istrash = request.getParameter("istrash");
		String name = role.getName();
		String p = request.getParameter("p");
		RoleBo bo = new RoleBo();
		role.setIsvalid("1".equals(istrash) ? 0 : 1);
		int total = bo.getRoleListSize(role);
		Page page = new Page(total, p, role, "load4RoleIndex");
		page.setQueryData("istrash", istrash == null ? "" : istrash);
		page.setQueryData("role.name", name == null ? "" : name);
		List<Role> roleList = bo.getRoleList(role);
		request.setAttribute("roleList", roleList);
		request.setAttribute("page", page);
		request.setAttribute("istrash", istrash);
		return mapping.findForward("success");
	}

	public ActionForward load4RoleAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		return mapping.findForward("success");
	}

	public ActionForward addRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		RoleBo bo = new RoleBo();
		RoleForm roleForm = (RoleForm) form;
		Role role = roleForm.getRole();
		bo.addRole(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.addRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4RoleInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		RoleBo bo = new RoleBo();
		Role role = bo.getRole(Integer.valueOf(id));
		request.setAttribute("role", role);
		return mapping.findForward("success");
	}

	public ActionForward load4RoleModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		RoleForm roleForm = (RoleForm) form;
		RoleBo bo = new RoleBo();
		Role role = bo.getRole(Integer.valueOf(id));
		roleForm.setRole(role);
		return mapping.findForward("success");
	}

	public ActionForward modifyRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		RoleBo bo = new RoleBo();
		RoleForm roleForm = (RoleForm) form;
		Role role = roleForm.getRole();
		bo.modifyRole(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.modifyRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward trashRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		RoleBo bo = new RoleBo();
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		role.setIsvalid(0);
		bo.modifyRoleIsvalid(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.trashRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward restoreRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		RoleBo bo = new RoleBo();
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		role.setIsvalid(1);
		bo.modifyRoleIsvalid(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.restoreRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward removeRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		RoleBo bo = new RoleBo();
		bo.removeRole(Integer.valueOf(id));

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.removeRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		smb.setQueryData("istrash", "1");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward disabledRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		role.setIsdisabled(1);
		RoleBo bo = new RoleBo();
		bo.disabledRole(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.disabledRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward enableRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String id = request.getParameter("id");
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		role.setIsdisabled(0);
		RoleBo bo = new RoleBo();
		bo.disabledRole(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb.setMessage(new ActionMessage("RoleAction.enableRole.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

	public ActionForward load4RoleAccessModify(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String id = request.getParameter("id");
		Role role = new Role();
		role.setId(Integer.valueOf(id));
		RoleBo bo = new RoleBo();
		List<Menu> menuList = bo.getAllMenuList(role);
		request.setAttribute("menuList", menuList);
		request.setAttribute("role", role);
		return mapping.findForward("success");
	}

	public ActionForward modifyRoleAccess(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		String roleid = request.getParameter("roleid");
		String menuids = request.getParameter("menuids");
		Role role = new Role();
		role.setId(Integer.valueOf(roleid));
		role.setMenuids(menuids);
		RoleBo bo = new RoleBo();
		bo.modifyRoleAccess(role);

		SysMessageBean smb = new SysMessageBean(false);
		smb
				.setMessage(new ActionMessage(
						"RoleAction.modifyRoleAccess.success"));
		smb.setLinkText(new ActionMessage("RoleAction.return"));
		smb.setAction("/load4RoleIndex");
		SysGlobals.setSysMessage(request, smb);
		return mapping.findForward("info");
	}

}