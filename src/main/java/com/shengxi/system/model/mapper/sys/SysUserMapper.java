package com.shengxi.system.model.mapper.sys;

import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.system.entites.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户类
 * @author matthew
 * @date 2019.05.13
 */
@Mapper
public interface SysUserMapper {

    Integer deleteByPrimaryKey(String id);

    Integer insert(SysUser record);

    Integer insertSelective(SysUser record);


    SysUser selectByPrimaryKey(String id);


    Integer updateByPrimaryKeySelective(SysUser record);

    Integer updateByPrimaryKey(SysUser record);

    /**
     * 通过用户编号获取用户信息
     * @param s
     * @return
     */
    SecurityUser getUserByNo(String s);

    /**
     * 修改密码
     * @param id id
     * @param encode 密码
     * @return status
     */
    Integer changePwd(String id, String encode);

    /**
     * 获取用户信息
     * @param sysUser
     * @return
     */
    SysUser selectUserNo(SysUser sysUser);
}