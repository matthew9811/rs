package com.shengxi.system.entity.sys;

import com.alibaba.excel.annotation.ExcelProperty;
import com.shengxi.system.entity.config.Tree;

/**
 * sys_menu
 *
 * @author matthew
 */
public class SysMenu extends Tree<SysMenu> {


    /**
     * 排序
     */
    @ExcelProperty(value = "编号", index = 1)
    private String sort;
    /**
     * 路径
     */
    @ExcelProperty(value = "路径", index = 3)
    private String url;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称", index = 2)
    private String menuName;

    /**
     * 图标
     */
    @ExcelProperty(value = "图标编码", index = 4)
    private String icon;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型", index = 6)
    private String type;

    /**
     * 权限
     */
    @ExcelProperty(value = "权限", index = 5)
    private String perms;



    public SysMenu() {
        super();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }



    @Override
    public String toString() {
        return "SysMenu{" +
                "sort='" + sort + '\'' +
                ", url='" + url + '\'' +
                ", menuName='" + menuName + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", perms='" + perms + '\'' +
                ", parentId='" + parentId + '\'' +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}