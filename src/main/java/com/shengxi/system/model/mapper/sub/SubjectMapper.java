package com.shengxi.system.model.mapper.sub;

import com.shengxi.system.entites.subEntity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
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

}
