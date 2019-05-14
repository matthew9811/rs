package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author matthew
 * @date 2019.05.13
 */
@Service("sysUser")
public class SysUserServices {

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 获取替代课程信息
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public SysUser selectSysUser(String s) {
        return sysUserMapper.getUserByNo(s);
    }


}
