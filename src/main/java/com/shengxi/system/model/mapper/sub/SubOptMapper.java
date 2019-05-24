package com.shengxi.system.model.mapper.sub;


import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubOptToolEntity;
import org.apache.ibatis.annotations.Mapper;
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
    List<SubOptEntity> selectSubOptEntityList(SubOptEntity subOptEntity);


    /**
     * 修改选择课程信息
     * @param subOptEntity 实体
     * @return Integer
     */
    Integer updateByStuOptEntity(SubOptEntity subOptEntity);


    /**
     *插入选择课程信息
     *@param subOptEntity 实体
     * @return Integer
     */
    Integer insertSubOptEntity(SubOptEntity subOptEntity);

    /**
     * 删除选择课程信息
     * @return list
     */
    Integer deleteStuOptEntity();

    /**
     * 获取学生选择课程信息
     * @param department 部门id
     * @param status 审核状态
     * @return list
     */
    List<SubOptToolEntity> selectSubStuList(String department,String status);
    /**
     * 修改选择课程审批状态
     * @param subOptEntity
     * @return Integer
     */
    Integer updateByStuOpt(SubOptEntity subOptEntity);
}
