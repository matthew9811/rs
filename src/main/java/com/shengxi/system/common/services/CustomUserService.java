package com.shengxi.system.common.services;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.config.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author : Matthew
 * @date : 2019/5/5 11:25
 * @description: 用户服务层
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userMapper.findByName(s);
        if (ObjectUtil.isNull(user)){
            throw  new UsernameNotFoundException("用户不存在");
        }

        return user;
    }
}
