package com.shengxi.system.model.mapper.sub;

import com.shengxi.system.entites.subEntity.ComSubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/4/24 15:08
 * 已修课程信息数据接口
 */
@Component
@Mapper
public interface ComSubMapper {
    /**
     * 获取有效已修课程信息
     * @return list
     */
    List<ComSubEntity> selectComSubEntityList(ComSubEntity comSubEntity);


    /**
     * 修改已修课程信息
     * @param comSubEntity 实体
     * @return Integer
     */
    Integer updateByComSubEntity(ComSubEntity comSubEntity);


    /**
     *插入已修课程信息
     *@param comSubEntity 实体
     * @return Integer
     */
    Integer insertComSubEntity(ComSubEntity comSubEntity);

    /**
     * 删除已修课程信息
     * @return list
     */
    Integer deleteSubject();

    /**
     * 判断是否已选择课程
     * @return lis
     */
    List<ComSubEntity> selectComSubList(ComSubEntity comSubEntity);
}
