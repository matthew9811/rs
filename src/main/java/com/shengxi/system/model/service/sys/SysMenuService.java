package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.sys.SysMenuEntity;
import java.util.List;
import java.util.Map;


/**
 * 菜单服务层接口
 *
 * @author matthew
 */
public interface SysMenuService {
    /**
     * 新增菜单
     *
     * @param sysMenuEntity elem
     * @return status
     */
    Integer insertEntity(SysMenuEntity sysMenuEntity);

    /**
     * 登录菜单初始化
     *
     * @param menuEntity elem
     * @return list
     */
    Map<String, Object> selectByInit(SysMenuEntity menuEntity);

    /**
     * 根据用户id获取对应的权限数据
     *
     * @param id user id
     * @return list
     */
    List<SysMenuEntity> selectPermList(String id);

    /**
     * 父类添加应用
     *
     * @return list
     */
    List<SysMenuEntity> selectOfParentAdd();
}
