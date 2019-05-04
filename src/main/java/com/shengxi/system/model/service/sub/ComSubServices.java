package com.shengxi.system.model.service.sub;

import com.shengxi.system.entites.subEntity.ComSubEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;
import com.shengxi.system.model.mapper.sub.ComSubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 郑杰
 * @Date: 2019/4/24 20:44
 * @deprecated 已修课程信息服务层
 */
@Service("comSub")
public class ComSubServices {
    @Autowired
    private ComSubMapper comSubMapper;

    /**
     * 获取已修课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<ComSubEntity> selectList() {
        return comSubMapper.selectComSubEntityList();
    }
    /**
     * 增加已修课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer addList(ComSubEntity comSubEntity){
        return comSubMapper.insereComSubEntity(comSubEntity);
    }
}
