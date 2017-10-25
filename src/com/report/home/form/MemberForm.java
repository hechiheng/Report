package com.report.home.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.manage.bean.Member;

public class MemberForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Member member;

	public MemberForm() {
		member = new Member();
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

}