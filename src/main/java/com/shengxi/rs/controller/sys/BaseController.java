package com.shengxi.rs.controller.sys;

import afu.org.checkerframework.checker.oigj.qual.O;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shengxi.rs.common.config.SysUser;
import com.shengxi.rs.common.domain.PageResult;
import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.util.AjaxResult;
import com.shengxi.rs.common.util.TableSupport;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/5/8 10:24
 * 基础controller
 */
public class BaseController {
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(DateUtils.parseDate(text));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageResult pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (ObjectUtil.isNotNull(pageNum) && ObjectUtil.isNotNull(pageSize)) {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }


    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {

        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success() {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error() {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message) {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(int code, String message) {
        return AjaxResult.error(code, message);
    }

//    /**
//     * 页面跳转
//     */
//    public String redirect(String url) {
//        return StringUtils.format("redirect:{}", url);
//    }
//
//    public SysUser getSysUser() {
//        return ShiroUtils.getSysUser();
//    }
//
//    public void setSysUser(SysUser user) {
//        ShiroUtils.setSysUser(user);
//    }
//
//    public Long getUserId() {
//        return getSysUser().getUserId();
//    }
//
//    public String getLoginName() {
//        return getSysUser().getLoginName();
//    }
}
