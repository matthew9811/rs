package com.shengxi.system.model.mapper.test;

import com.shengxi.system.entites.test.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Matthew
 * @Date: 2019/4/9 20:39
 * @Description: 持久数据层模版
 */
@Component
@Mapper
public interface TestMapper {

    /**
     * 直接获取所有的有效数据
     * @return list
     */
    List<TestEntity> selectTestEntityList();


    /**
     * update对应行
     * @param entity 实体
     * @return Integer
     */
    Integer updateByTestEntityList(TestEntity entity);

}
