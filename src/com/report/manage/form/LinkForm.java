package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.home.bean.Link;

public class LinkForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Link link;

	public LinkForm() {
		link = new Link();
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public Link getLink() {
		return link;
	}

}