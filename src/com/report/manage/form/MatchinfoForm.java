package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Matchinfo;

public class MatchinfoForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Matchinfo matchinfo;

	public MatchinfoForm() {
		matchinfo = new Matchinfo();
	}

	public void setMatchinfo(Matchinfo matchinfo) {
		this.matchinfo = matchinfo;
	}

	public Matchinfo getMatchinfo() {
		return matchinfo;
	}

}