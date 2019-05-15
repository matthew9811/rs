package com.shengxi.rs.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.entites.sys.SysUser;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

/**
 * @author : Matthew
 * @Date: 2019/4/26 15:41
 * @Description:
 */
public class SecurityUser extends SysUser implements UserDetails {

    /**
     * 权限
     */
    private List<SysMenuEntity> permList;

    public SecurityUser() {
        super();
    }

    /**
     * 获取菜单权限
     *
     * @return list
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permList.parallelStream().filter(p -> !ObjectUtils.isEmpty(p.getPerms())).map(p -> new SimpleGrantedAuthority(p.getPerms())).collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return getUserNo();
    }


    /**
     * 用户是否锁定
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 密码是否过期
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户是否激活
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return false;
    }

    public List<SysMenuEntity> getPermList() {
        return permList;
    }

    public void setPermList(List<SysMenuEntity> permList) {
        this.permList = permList;
    }
}
