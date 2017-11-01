package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Matchtype;

public class MatchtypeForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Matchtype matchtype;

	public MatchtypeForm() {
		matchtype = new Matchtype();
	}

	public void setMatchtype(Matchtype matchtype) {
		this.matchtype = matchtype;
	}

	public Matchtype getMatchtype() {
		return matchtype;
	}

}