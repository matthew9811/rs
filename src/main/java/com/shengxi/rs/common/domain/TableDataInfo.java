package com.shengxi.rs.common.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Matthew
 * @Date: 2019/5/8 11:45
 * @Description: 表格分页数据对象
 */
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private long count;
    /**
     * 列表数据
     */
    private List<?> data;
    /**
     * 消息状态码
     */
    private int code;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param count 总记录数
     */
    public TableDataInfo(List<?> list, int count) {
        this.data = list;
        this.count = count;
    }

    public long getcount() {
        return count;
    }

    public void setcount(long count) {
        this.count = count;
    }

    public List<?> getdata() {
        return data;
    }

    public void setdata(List<?> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
