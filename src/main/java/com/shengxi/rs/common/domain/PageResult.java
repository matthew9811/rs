package com.shengxi.rs.common.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Matthew
 * @Date: 2019/4/19 16:04
 * @Description: 分页实体类
 */
public class PageResult<T> implements Serializable {
    /**
     * home page
     */
    int page;

    /**
     * size of each page
     */
    int limit;

    /**
     * total data quantity
     */
    long count;

    /**
     * status code
     */
    String code;

    /**
     * describe message
     */
    String msg;

    /**
     * returned data
     */
    List<T> data;

    /**
     * any condition type
     */
    T example;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }
}