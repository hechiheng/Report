package com.report.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

public class Page {

	// 默认列表每页显示行数
	private int listRows = 5;
	// 起始行数
	private int firstRow;
	// 分页总页面数
	private int totalPages;
	// 总行数
	private int totalRows;
	// 当前页数
	private int nowPage;
	// 上一页
	private int prePage;
	// 下一页
	private int nextPage;

	private HashMap<String, String> queryData;
	private String action;

	public Page(int total, String page, Object o, String action) {
		totalRows = total;
		this.setAction(action);
		queryData = new HashMap<String, String>();

		if (page == null || page.equals("0")) {
			nowPage = 1;
		} else {
			nowPage = Integer.valueOf(page);
		}
		if (this.totalRows % this.listRows == 0) {
			this.totalPages = (this.totalRows / this.listRows);
		} else {
			this.totalPages = (this.totalRows / this.listRows + 1);
		}
		firstRow = (nowPage - 1) * listRows;
		if (nowPage - 1 > 0) {
			prePage = nowPage - 1;
		} else {
			prePage = 1;
		}
		if (nowPage + 1 < totalPages) {
			nextPage = nowPage + 1;
		} else {
			nextPage = totalPages;
		}

		try {
			BeanUtils.setProperty(o, "firstRow", firstRow);
			BeanUtils.setProperty(o, "listRows", listRows);

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public int getListRows() {
		return listRows;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setQueryData(String key, String value) {
		queryData.put(key, value);
	}

	public HashMap getQueryData() {
		return this.queryData;
	}

}
