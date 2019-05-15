package com.shengxi.system.model.service.sys;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.druid.sql.ast.expr.SQLNullExpr;
import com.shengxi.rs.common.contant.SysContant;
import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.common.contant.BaseControllerContant;
import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import java.sql.SQLSyntaxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author matthew
 * @date 2019.05.13
 */
@Service("sysUser")
public class SysUserServices {

    @Autowired
    private SysUserMapper sysUserMapper;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


//    /**
//     * 插入用户数据
//     * 单例
//     *
//     * @param sysUser sysUser
//     * @return status
//     */
//    @Transactional(readOnly = false, rollbackFor = SQLSyntaxErrorException.class)
//    public Integer saveUser(SysUser sysUser) {
//        /**
//         * 密文保存密码
//         */
//        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
//        sysUser.setStatus(SysContant.NORMAL);
//        sysUser.setId(IdUtil.uuid());
//        sysUser.setDelFlag(BaseControllerContant.DEL_FLAG_NOT);
//        return sysUserMapper.insert(sysUser);
//    }
//
//    /**
//     * 修改密码校验
//     *
//     * @param userNo 编号
//     * @param oldPwd 旧密码
//     * @param newPwd 新密码
//     * @return status
//     */
//    public Integer editPassword(String userNo, String oldPwd, String newPwd) {
//        SysUser user = sysUserMapper.getUserByNo(userNo);
//        if (ObjectUtil.isNull(user)) {
//            throw new IllegalArgumentException("用户不存在");
//        }
//        if (BooleanUtil.isFalse(bCryptPasswordEncoder.matches(oldPwd, user.getPassword()))) {
//            throw new IllegalArgumentException("密码错误");
//        }
//        return sysUserMapper.changePwd(user.getId(), bCryptPasswordEncoder.encode(newPwd));
//    }
}
