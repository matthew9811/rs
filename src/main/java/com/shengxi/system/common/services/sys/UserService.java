package com.shengxi.system.common.services.sys;

import com.shengxi.rs.common.config.SysUser;
import com.shengxi.system.entites.subEntity.ComSubEntity;
import com.shengxi.system.model.mapper.sub.ComSubMapper;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/5/8 00:09
 * 通用用户类
 */
@Service("userImpl")
public class UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 获取已修课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public SysUser selectUserNo(String userNo) {
        return sysUserMapper.findByNo(userNo);
    }
}
