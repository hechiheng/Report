package com.report.manage.bo;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {

    public static void main(String[] args) {
        String a="1";
        String b=DigestUtils.md5Hex(a);
        System.out.println(b);
    }

}
