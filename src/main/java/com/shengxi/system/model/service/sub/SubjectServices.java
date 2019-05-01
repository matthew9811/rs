package com.shengxi.system.model.service.sub;

import com.shengxi.system.entites.subEntity.SubjectEntity;
import com.shengxi.system.entites.test.TestEntity;
import com.shengxi.system.model.mapper.sub.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/4/24 15:08
 * @deprecated 课程信息服务层
 */
@Service("subject")
public class SubjectServices {
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 获取课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<SubjectEntity> selectList() {
        return subjectMapper.selectSubjectEntityList();
    }
    /**
     * 增加课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer addList(SubjectEntity subjectEntity){
        System.out.println("addList到");
        return subjectMapper.addSubject(subjectEntity);
    }
}
