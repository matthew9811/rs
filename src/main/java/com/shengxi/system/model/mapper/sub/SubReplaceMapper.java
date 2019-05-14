package com.shengxi.system.model.mapper.sub;

import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 *
 * @author : 郑杰
 * @Date: 2019/5/2 20:38
 * 替代课程信息数据接口
 */
@Component
@Mapper
public interface SubReplaceMapper {
    /**
     * 获取有效替代课程信息
     * @return list
     */
    List<SubReplaceEntity> selectSubReplaceEntityList();


    /**
     * 修改替代课程信息
     * @param subReplaceEntity 实体
     * @return Integer
     */
    Integer updateBySubReplaceEntityList(SubReplaceEntity subReplaceEntity);


    /**
     *插入替代课程信息
     *@param subReplaceEntity 实体
     * @return Integer
     */
    Integer insertSubReplaceEntity(@Param("comSubEntity")SubReplaceEntity subReplaceEntity);

    /**
     * 删除替代课程信息
     * @return list
     */
    Integer deleteSubject();
}
