package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.User;

public class UserForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private User user;

	public UserForm() {
		user = new User();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}