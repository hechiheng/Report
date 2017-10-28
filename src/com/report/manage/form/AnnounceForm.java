package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.home.bean.Announce;

public class AnnounceForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Announce announce;

	public AnnounceForm() {
		announce = new Announce();
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public Announce getAnnounce() {
		return announce;
	}

}