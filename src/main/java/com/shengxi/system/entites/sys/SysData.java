package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;

/**
 * 字典数据
 * @author matthew
 */
public class SysData extends BaseEntity {
    /**
     * 键
     */
    private String typeLabel;

    /**
     * 值
     */
    private String typeValue;

    /**
     * 状态
     */
    private String status;

    /**
     * 数据编码
     */
    private String typeCode;

    /**
     * 是否默认
     */
    private String isDefault;

    /**
     * table回显样式
     */
    private String listCss;

    /**
     * 类型编号
     */
    private String typeNo;

    /**
     * 样式属性
     */
    private String typeCss;

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getListCss() {
        return listCss;
    }

    public void setListCss(String listCss) {
        this.listCss = listCss;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeCss() {
        return typeCss;
    }

    public void setTypeCss(String typeCss) {
        this.typeCss = typeCss;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeLabel=").append(typeLabel);
        sb.append(", typeValue=").append(typeValue);
        sb.append(", status=").append(status);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", listCss=").append(listCss);
        sb.append(", typeNo=").append(typeNo);
        sb.append(", typeCss=").append(typeCss);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remark=").append(remark);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}