package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.home.bean.Message;

public class MessageForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private Message message;

	public MessageForm() {
		setMessage(new Message());
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

}