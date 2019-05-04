package com.shengxi.system.model.service.sub;

import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;
import com.shengxi.system.model.mapper.sub.SubOptMapper;
import com.shengxi.system.model.mapper.sub.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
/**
 * @author : 郑杰
 * @Date: 2019/5/3 22:49
 * @deprecated 选择课程信息服务层
 */
@Service("subOpt")
public class SubOptServices {
    @Autowired
    private SubOptMapper subOptMapper;

    /**
     * 获取选择课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<SubOptEntity> selectList() {
        return subOptMapper.selectSubOptEntityList();
    }
    /**
     * 增加选择课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer addList(SubOptEntity subOptEntity){
        return subOptMapper.insereStuOptEntity(subOptEntity);
    }
}
