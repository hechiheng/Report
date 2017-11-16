package com.report.manage.bo;

import org.apache.commons.lang.StringUtils;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
//		t.test("a", "b", "c", "d", "e");
		
//		String s=StringUtils.repeat("a", 3);
//		System.out.println(s);
		
		String s="111.txt";
		System.out.println(s.substring(s.lastIndexOf(".")+1));
	}

	private void test(String a, String... b) {
		System.out.println(a);
		System.out.println("----------");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
		
	}

}
