package com.shengxi.system.entity.sys;

import com.shengxi.system.entity.config.BaseEntity;

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
    private String typeName;

    /**
     * 类型编号
     */
    private String typeNo;

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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    @Override
    public String toString() {
        return "SysDict{" +
                "typeName='" + typeName + '\'' +
                ", typeNo='" + typeNo + '\'' +
                ", status='" + status + '\'' +
                ", sysDataList=" + sysDataList +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}