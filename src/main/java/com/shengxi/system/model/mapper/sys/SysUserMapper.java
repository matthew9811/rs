package com.shengxi.system.model.mapper.sys;

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

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);


    SysUser selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 通过用户编号获取用户信息
     * @param s
     * @return
     */
    SysUser getUserByNo(String s);
}