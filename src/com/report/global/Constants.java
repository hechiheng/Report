package com.report.global;

public class Constants {
    
    /**
     * 系统模块session标识Key，每个模块分别设计自己的变量，如主模块：MAIN_SESSION
     */
    public final static String MAIN_SESSION = "LOGIN_INFO";
    /**
     * 图片新闻
     */
    public final static String PICTURE_CHAN_ID = "PICTURE";
    
    /**
     * 分页大小
     */
    public final static int PERMIT_PAGESIZE = 20;

    /**
     * 分页大小
     */
    public final static int PAGE_SIZE = 10;

    /**
     * 对应二级页面信息发布的分页大小
     */
    public final static int PAGE_INDEX_SIZE = 25;
    
    /**
     * 普通会员对应数据库Role表的ID
     */
    public final static String[] NORMAL_MEMBER = {"00001"}; 
    
    /**
     * 普通会员对应数据库Permit表中的标识
     */
    public final static String NORMAL_MEMBER_SIGN = "00001";
    
    /**
     * 高级会员对应数据库Permit表中的标识
     */
    public final static String ADVANCE_MEMBER_SIGN = "00002";
    
    /**
     * 高级会员对应数据库Role表的ID
     */
    public final static String[] ADVANCE_MEMBER = {"00002"};
    
    /**
     * 定点机构会员对应Permit表的ID
     */
    public final static String AGENCY_MEMBER = "00004";
    
    /**
     * 私有构造方法
     */
    private Constants() {
    }

}