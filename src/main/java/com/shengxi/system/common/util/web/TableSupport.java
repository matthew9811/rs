package com.shengxi.system.common.util.web;

import com.shengxi.system.common.constant.PageConstant;
import com.shengxi.system.entity.config.PageResult;

/**
 * 表格数据处理
 *
 * @author 梁焰豪
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageResult getPageResult() {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(ServletUtils.getParameterToInt(PageConstant.PAGE_NUM));
        pageResult.setPageSize(ServletUtils.getParameterToInt(PageConstant.PAGE_SIZE));
        pageResult.setOrderByColumn(ServletUtils.getParameter(PageConstant.ORDER_BY_COLUMN));
        pageResult.setIsAsc(ServletUtils.getParameter(PageConstant.IS_ASC));
        return pageResult;
    }

    public static PageResult buildPageRequest() {
        return getPageResult();
    }
}
