package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;

/**
 * sys_data
 * @author matthew
 */
public class SysData extends BaseEntity {

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 类型编号
     */
    private String typeNo;


    private static final long serialVersionUID = 1L;

    public SysData(){
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    @Override
    public String toString() {
        return "SysData{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", typeNo='" + typeNo + '\'' +
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