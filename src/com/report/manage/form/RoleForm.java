package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Role;

public class RoleForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Role role;

	public RoleForm() {
		role = new Role();
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

}