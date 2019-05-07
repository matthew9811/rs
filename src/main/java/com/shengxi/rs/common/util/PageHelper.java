package com.shengxi.rs.common.util;


import com.shengxi.rs.common.domain.PageResult;

import java.util.List;

/**
 * @Auther: Matthew
 * @Date: 2019/4/19 15:29
 * @Description:
 */
public class PageHelper {

    public static Object startPage(List<?> list) {
        PageResult<?> pageResult = new PageResult<>();
        com.github.pagehelper.PageHelper.startPage(pageResult.getPage(), pageResult.getLimit());
        return Object.class;
    }
}
