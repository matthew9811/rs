package com.shengxi.system.model.service.sub;

import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubOptToolEntity;
import com.shengxi.system.model.mapper.sub.SubOptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
/**
 * @author : 郑杰
 * @Date: 2019/5/3 22:49
 * 选择课程信息服务层
 */
@Service("subOpt")
public class SubOptServices {
    @Autowired
    private SubOptMapper subOptMapper;

    /**
     * 获取选择课程信息
     *@param subOptEntity 实体
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<SubOptEntity> selectList(SubOptEntity subOptEntity) {
        return subOptMapper.selectSubOptEntityList(subOptEntity);
    }
    /**
     * 增加选择课程信息
     *@param subOptEntity 实体
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer insertSubOptEntity(SubOptEntity subOptEntity){
        return subOptMapper.insertSubOptEntity(subOptEntity);
    }
    /**
     * 增加选择课程信息
     *@param distinguish 审核状态
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public  List<SubOptToolEntity> selectSubStuList(String distinguish){
        return subOptMapper.selectSubStuList(distinguish);
    }
    /**
     * 增加选择课程信息
     *@param id id
     * @param status 审核状态
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer updateByStuOpt(String status,String id){
        return subOptMapper.updateByStuOpt(id,status);
    }
}
