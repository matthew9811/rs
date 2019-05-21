package com.shengxi.system.common.services.sys;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import com.shengxi.system.model.service.sys.SysMenuServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author matthew
 * @date 2019.05.13
 * 用户登录权限配置类
 * 获取用户拥有的角色
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysMenuServices sysMenuServices;

    /**
     * 通过用户登录帐号获取数据
     *
     * @param userNo userNo
     * @return userDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
        /**
         * 用户校验
         */
        SecurityUser user = sysUserMapper.getUserByNo(userNo);
        if (ObjectUtil.isNull(user)) {
            throw new AuthenticationCredentialsNotFoundException("帐号不存在");
        }

        SecurityUser securityUser = new SecurityUser();
        BeanUtil.copyProperties(user, securityUser);
        List<SysMenuEntity> permList = sysMenuServices.selectPermList(((SecurityUser) user).getId());
        securityUser.setPermList(permList);
        return securityUser;
    }
}
