package com.shengxi.system.model.mapper.sub;

import com.shengxi.system.entites.subEntity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/4/24 15:08
 * @deprecated 课程信息数据接口
 */
@Component
@Mapper
public interface SubjectMapper {
    /**
     * 获取课程信息
     * @return list
     */
    List<SubjectEntity> selectSubjectEntityList();

    /**
     * update对应行
     * @param subjectEntity 实体
     * @return Integer
     */
    Integer updateSubject(SubjectEntity subjectEntity);

    /**
     *update对应行
     *@param subjectEntity 实体
     * @return Integer
     */
    Integer insereSubject(SubjectEntity subjectEntity);

    /**
     * delete对应行
     * @return list
     */
    Integer deleteSubject();

    /**
     * add对应行
     * @return list
     */
    Integer addSubject(@Param("subjectEntity") SubjectEntity subjectEntity);
}
