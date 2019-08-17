package com.shengxi.system.model.service.test;

import com.shengxi.system.entity.test.TestEntity;
import com.shengxi.system.model.mapper.test.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/3/28 16:58
 * @Description: 服务层模版
 */
@Service("test")
public class TestServices {

    @Autowired
    private TestMapper testMapper;

    /**
     * 直接获取所有的数据
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<TestEntity> selectList() {
        return testMapper.selectTestEntityList();
    }

    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer updateTest(TestEntity testEntity){
        return testMapper.updateByTestEntityList(testEntity);
    }
}
