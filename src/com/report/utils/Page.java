package com.report.utils;

import java.lang.reflect.InvocationTargetException;

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

	public Page(int total, String page, Object o) {
		totalRows = total;
		if (page == null) {
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

}
