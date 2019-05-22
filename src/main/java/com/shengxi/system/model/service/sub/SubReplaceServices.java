package com.shengxi.system.model.service.sub;

import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.model.mapper.sub.SubReplaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/5/2 22:08
 * 替代课程信息服务层
 */
@Service("subReplace")
public class SubReplaceServices {

    @Autowired
    private SubReplaceMapper subReplaceMapper;

    /**
     * 获取替代课程信息
     *@param subReplaceEntity 实体
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<SubReplaceEntity> selectList(SubReplaceEntity subReplaceEntity) {
        return subReplaceMapper.selectSubReplaceEntityList(subReplaceEntity);
    }
    /**
     * 增加替代课程信息
     *@param subReplaceEntity 实体
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer insertSubReplaceEntity(SubReplaceEntity subReplaceEntity){
        return subReplaceMapper.insertSubReplaceEntity(subReplaceEntity);
    }
    /**
     * 修改替代课程信息
     *@param subReplaceEntity 实体
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer updateBySubReplaceEntityList(SubReplaceEntity subReplaceEntity){
        return subReplaceMapper.updateBySubReplaceEntity(subReplaceEntity);
    }
}
