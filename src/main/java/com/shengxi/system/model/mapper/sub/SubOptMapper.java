package com.shengxi.system.model.mapper.sub;


import com.shengxi.system.entites.subEntity.SubOptEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/5/2 14:18
 * 选择课程信息数据接口
 */
@Component
@Mapper
public interface SubOptMapper {
    /**
     * 获取有效选择课程信息
     * @return list
     */
    List<SubOptEntity> selectSubOptEntityList();


    /**
     * 修改选择课程信息
     * @param subOptEntity 实体
     * @return Integer
     */
    Integer updateByStuOptEntityList(SubOptEntity subOptEntity);


    /**
     *插入选择课程信息
     *@param subOptEntity 实体
     * @return Integer
     */
    Integer insereSubOptEntity(@Param("subOptEntity")SubOptEntity subOptEntity);

    /**
     * 删除选择课程信息
     * @return list
     */
    Integer deleteStuOptEntity();

    /**
     * 获取学生选择课程信息
     * @return list
     */
    List<SubOptEntity> selectSubStuList(String distinguish);
    /**
     * 修改选择课程审批状态
     * @param id
     * @param status
     * @return Integer
     */
    Integer updateByStuOpt(String status,String id);
}
