package com.shengxi.system.model.mapper.sys;

//import com.shengxi.rs.common.config.SysUser;
import com.shengxi.rs.common.config.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/5/5 11:29
 * @Description:
 */
@Component
@Mapper
public interface SysUserMapper {
    /**
     * 通过用户名搜索
     * @param userName username
     * @return sysUser
     */
    //SysUser findByName(String userName);

    /**
     * 通过用户编号搜索
     * @param userNo
     * @return sysUser
     */
    SysUser findByNo(String userNo);
}
