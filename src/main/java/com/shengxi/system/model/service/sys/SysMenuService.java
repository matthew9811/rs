package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.sys.SysMenu;
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
     * @param sysMenu elem
     * @return status
     */
    Integer insertEntity(SysMenu sysMenu);

    /**
     * 登录菜单初始化
     *
     * @param menuEntity elem
     * @return list
     */
    Map<String, Object> selectByInit(SysMenu menuEntity);

    /**
     * 根据用户id获取对应的权限数据
     *
     * @param id user id
     * @return list
     */
    List<SysMenu> selectPermList(String id);

    /**
     * 父类添加应用
     *
     * @return list
     */
    List<SysMenu> selectOfParentAdd();

    /**
     * 获取所有可以打印的数据
     * @return list
     */
    List<SysMenu> selectListToExcel();

    /**
     * 为index菜单框获取数据
     * @return list
     */
    List<SysMenu> selectListByIndex();
}
