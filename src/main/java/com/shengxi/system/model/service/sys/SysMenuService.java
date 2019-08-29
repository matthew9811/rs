package com.shengxi.system.model.service.sys;

import com.shengxi.system.entity.sys.SysMenu;
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
     * 无筛选获取所有数据
     *
     * @return list
     */
    List<SysMenu> selectByList();

    /**
     * 根据id获取数据
     * @param id id
     * @return sysMenu
     */
    SysMenu selectMenuById(String id);

    /**
     * 根据id删除数据
     * @param id id
     * @param userNo userNo
     * @return boolean
     */
    Integer deleteById(String id, String userNo);
}
