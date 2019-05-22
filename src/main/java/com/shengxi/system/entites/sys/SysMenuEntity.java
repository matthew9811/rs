package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;
import com.shengxi.rs.common.domain.Tree;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * sys_menu
 *
 * @author matthew
 */
public class SysMenuEntity extends  Tree<SysMenuEntity> {


    /**
     * 路径
     */
    private String url;

    /**
     * 名称
     */
    private String menuName;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型
     */
    private String type;

    /**
     * 权限
     */
    private String perms;

    public SysMenuEntity() {
        super();
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
        return "SysMenuEntity{" +
                "url='" + url + '\'' +
                ", menuName='" + menuName + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", perms='" + perms + '\'' +
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