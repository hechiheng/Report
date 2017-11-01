package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.home.bean.Notice;

public class NoticeForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Notice notice;

	public NoticeForm() {
		notice = new Notice();
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Notice getNotice() {
		return notice;
	}

}