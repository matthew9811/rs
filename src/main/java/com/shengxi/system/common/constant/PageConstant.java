package com.shengxi.system.common.constant;

/**
 * @author: Matthew
 * @Date: 2019/5/8 11:08
 * @Description: 页面通用常量
 */
public class PageConstant {
    /**
     * 统一错误页面路径
     */
    public static final String ERROR_PATH = "/common";
    /**
     * 404路径
     */
    public static final String E404 = "/404";
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "page";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "limit";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "isAsc";
}
