package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Matchapply;

public class MatchapplyForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Matchapply matchapply;

	public MatchapplyForm() {
		matchapply = new Matchapply();
	}

	public void setMatchapply(Matchapply matchapply) {
		this.matchapply = matchapply;
	}

	public Matchapply getMatchapply() {
		return matchapply;
	}

}