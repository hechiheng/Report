package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Website;

public class WebsiteForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Website website;

	public WebsiteForm() {
		website = new Website();
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public Website getWebsite() {
		return website;
	}

}