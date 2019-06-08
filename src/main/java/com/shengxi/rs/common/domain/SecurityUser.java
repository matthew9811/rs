package com.shengxi.rs.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shengxi.system.entites.sys.SysMenu;
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
    private List<SysMenu> permList;

    private String token;

    private Long loginTime;

    private Long expireTime;

    public SecurityUser() {
        super();
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        return getUserName();
    }


    /**
     * 用户是否锁定
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 密码是否过期
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户是否激活
     *
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<SysMenu> getPermList() {
        return permList;
    }

    public void setPermList(List<SysMenu> permList) {
        this.permList = permList;
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "permList=" + permList +
                ", token='" + token + '\'' +
                ", loginTime=" + loginTime +
                ", expireTime=" + expireTime +
                ", userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
