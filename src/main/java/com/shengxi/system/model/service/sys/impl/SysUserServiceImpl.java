package com.shengxi.system.model.service.sys.impl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.common.constant.SysConstant;
import com.shengxi.system.common.util.IdUtil;
import com.shengxi.system.common.constant.BaseConstant;
import com.shengxi.system.entity.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import com.shengxi.system.model.service.sys.SysUserService;
import java.sql.SQLSyntaxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author matthew
 * @date 2019.05.13
 */
@Service("sysUser")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 插入用户数据
     * 单例
     *
     * @param sysUser sysUser
     * @return status
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = SQLSyntaxErrorException.class)
    public Integer saveUser(SysUser sysUser) {
        /**
         * 密文保存密码
         */
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        sysUser.setStatus(SysConstant.NORMAL);
        sysUser.setId(IdUtil.uuid());
        sysUser.setDelFlag(BaseConstant.DEL_FLAG_NOT);
        return sysUserMapper.insert(sysUser);
    }

    /**
     * 修改密码校验
     *
     * @param userNo 编号
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return status
     */
    public Integer editPassword(String userNo, String oldPwd, String newPwd) {
        SysUser user = sysUserMapper.getUserByNo(userNo);
        if (ObjectUtil.isNull(user)) {
            throw new IllegalArgumentException("用户不存在");
        }
        if (BooleanUtil.isFalse(bCryptPasswordEncoder.matches(oldPwd, user.getPassword()))) {
            throw new IllegalArgumentException("密码错误");
        }
        return sysUserMapper.changePwd(user.getId(), bCryptPasswordEncoder.encode(newPwd));
    }
}
