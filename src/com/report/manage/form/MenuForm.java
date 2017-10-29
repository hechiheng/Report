package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Menu;

public class MenuForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Menu menu;

	public MenuForm() {
		menu = new Menu();
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

}