package com.shengxi.system.model.service.sub;

import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;
import com.shengxi.system.model.mapper.sub.SubReplaceMapper;
import com.shengxi.system.model.mapper.sub.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/5/2 22:08
 * @deprecated 替代课程信息服务层
 */
@Service("subReplace")
public class SubReplaceServices {
    @Autowired
    private SubReplaceMapper subReplaceMapper;

    /**
     * 获取替代课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<SubReplaceEntity> selectList() {
        return subReplaceMapper.selectSubReplaceEntityList();
    }
    /**
     * 增加替代课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer addList(SubReplaceEntity subReplaceEntity){
        return subReplaceMapper.insereSubReplaceEntity(subReplaceEntity);
    }
}
