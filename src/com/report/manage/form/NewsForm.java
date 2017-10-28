package com.report.manage.form;

import org.apache.struts.validator.ValidatorForm;

import com.report.home.bean.News;

public class NewsForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private News news;

	public NewsForm() {
		setNews(new News());
	}

	public void setNews(News news) {
		this.news = news;
	}

	public News getNews() {
		return news;
	}

}