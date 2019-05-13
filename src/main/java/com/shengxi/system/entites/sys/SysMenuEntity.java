package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;
import com.shengxi.rs.common.domain.Tree;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * sys_menu
 * @author matthew
 */
public class SysMenuEntity extends BaseEntity {

    /**
     * 父类id
     */
    private String parentId;

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
    /**
     * 子结点
     */
    private List<SysMenuEntity> child;

    public List<SysMenuEntity> getChild() {
        return child;
    }

    public void setChild(List<SysMenuEntity> child) {
        this.child = child;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getIcon() {
        return icon;
    }

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
                "parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                ", menuName='" + menuName + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", perms='" + perms + '\'' +
                ", child=" + child +
                '}';
    }
}