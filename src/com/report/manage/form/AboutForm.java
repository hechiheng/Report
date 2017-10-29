package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.home.bean.About;

public class AboutForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private About about;

	public AboutForm() {
		about = new About();
	}

	public void setAbout(About about) {
		this.about = about;
	}

	public About getAbout() {
		return about;
	}

}