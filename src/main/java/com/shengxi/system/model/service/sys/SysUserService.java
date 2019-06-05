package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.sys.SysUser;

/**
 * 用户服务层接口
 *
 * @author matthew
 */
public interface SysUserService {
    /**
     * 保存用户
     * @param sysUser user elem
     * @return status
     */
    Integer saveUser(SysUser sysUser);
}
