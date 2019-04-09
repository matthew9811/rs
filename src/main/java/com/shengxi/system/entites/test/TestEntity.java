package com.shengxi.system.entites.test;

import com.shengxi.rs.common.domain.BaseEntity;

/**
 * @author : Matthew
 * @Date: 2019/3/23 14:25
 * @Description: 测试实体类
 */
public class TestEntity extends BaseEntity {
    /**姓名*/
    private String name;
    /**年龄*/
    private Integer age;

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

    @Override
    public String toString() {
        return "TestEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
