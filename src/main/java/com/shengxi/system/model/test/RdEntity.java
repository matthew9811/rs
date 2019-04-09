package com.shengxi.system.model.test;

import com.shengxi.rs.common.domain.BaseEntity;

import java.io.Serializable;

/**
 * @author: Matthew
 * @Date: 2019/4/6 01:46
 * @Description:
 */
public class RdEntity extends BaseEntity implements Serializable {
    private String id;
    private String name;
    private Integer age;

    public RdEntity() {
    }

    public RdEntity(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}