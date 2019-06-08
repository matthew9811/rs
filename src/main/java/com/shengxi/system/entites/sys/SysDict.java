package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 字典类
 * sys_dict
 *
 * @author matthew
 * @date 2019.06.06
 */
public class SysDict extends BaseEntity {
    /**
     * 类型名
     */
    private String type_name;

    /**
     * 类型编号
     */
    private String type_no;

    /**
     * 状态
     */
    private String status;
    /**
     * 字典值
     */
    private List<SysData> sysDataList;

    private static final long serialVersionUID = 1L;

    public SysDict() {
        super();
    }

    public List<SysData> getSysDataList() {
        return sysDataList;
    }

    public void setSysDataList(List<SysData> sysDataList) {
        this.sysDataList = sysDataList;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_no() {
        return type_no;
    }

    public void setType_no(String type_no) {
        this.type_no = type_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysDict{" +
                "type_name='" + type_name + '\'' +
                ", type_no='" + type_no + '\'' +
                ", status='" + status + '\'' +
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