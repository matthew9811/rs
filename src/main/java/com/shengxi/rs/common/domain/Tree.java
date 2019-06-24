package com.shengxi.rs.common.domain;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Matthew
 * @Date: 2019/4/7 14:25
 * @Description:
 */
public class Tree<T> extends BaseEntity{
    /**
     * 图标
     */
    private String icon;
    /**
     * 节点的子节点
     */
    private List<Tree<T>> children = new ArrayList<>();
    /**
     * 属性
     */
    private Map<String, Object> attr;

    /**
     * 父ID
     */
    protected String parentId;
    public Tree() {
        super();
    }

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}