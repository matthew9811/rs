package com.shengxi.system.model.mapper.sub;

import com.shengxi.system.entites.subEntity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/4/24 15:08
 * 课程信息数据接口
 */
@Component
@Mapper
public interface SubjectMapper {
    /**
     * 获取有效课程信息
     * @return list
     */
    List<SubjectEntity> selectSubjectEntityList(SubjectEntity subjectEntity);

    /**
     * 修改课程信息
     * @param subjectEntity 实体
     * @return Integer
     */
    Integer updateSubject(SubjectEntity subjectEntity);

    /**
     *插入课程信息
     *@param subjectEntity 实体
     * @return Integer
     */
    Integer insertSubject(SubjectEntity subjectEntity);

    /**
     * 删除课程信息
     * @return list
     */
    Integer deleteSubject();

    /**
     * add对应行
     * @return list
     */
    Integer addSubject(SubjectEntity subjectEntity);

    /**
     * 搜索课程代码或课程名
     * @return list
     */
    List<SubjectEntity> souSubjectEntityList(String sou);
}
