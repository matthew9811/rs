package com.shengxi.system.model.service.sys.impl;

import com.shengxi.system.entites.sys.SysDeptEntity;
import com.shengxi.system.model.mapper.sys.SysDeptMapper;
import com.shengxi.system.model.service.sys.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : matthew
 * @Date: 2019/5/15 14:35
 * 部门服务层
 */
@Service("sysDept")
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 增加部门信息
     *
     * @param sysDeptEntity 实体
     * @return list
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer insertSysDeptEntity(SysDeptEntity sysDeptEntity) {
        return sysDeptMapper.insertSysDeptEntity(sysDeptEntity);
    }

    /**
     * 获取替代课程信息
     *
     * @return list
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<SysDeptEntity> selectList(SysDeptEntity sysDeptEntity) {
        return sysDeptMapper.selectSysDeptEntityList(sysDeptEntity);
    }
}
