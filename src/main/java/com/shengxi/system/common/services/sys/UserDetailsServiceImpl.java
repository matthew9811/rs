package com.shengxi.system.common.services.sys;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author matthew
 * @date 2019.05.13
 * 用户登录权限配置类
 * 获取用户拥有的角色
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 通过用户登录帐号获取数据
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /**
         * 用户校验
         */
        UserDetails user = sysUserMapper.getUserByNo(s);
        if (ObjectUtil.isNull(user)){
            throw new AuthenticationCredentialsNotFoundException("帐号不存在");
        }
        return null;
    }
}
