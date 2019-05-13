package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author matthew
 * @date 2019.05.13
 */
@Service("sysUser")
public class SysUserServices {

    @Autowired
    private SysUserMapper sysUserMapper;

}
