package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 菜单接口
 *
 * @author matthew
 */
@Repository
@Mapper
public interface SysMenuMapper {


    /**
     * 插入菜单 强制插入
     *
     * @param record record
     * @return status
     */
    int insert(SysMenu record);

    /**
     * 选择行插入
     *
     * @param record record
     * @return status
     */
    int insertSelective(SysMenu record);

    /**
     * 通过id查询
     *
     * @param id id
     * @return status
     */
    SysMenu selectById(String id);

    /**
     * 整体update
     *
     * @param record record
     * @return status
     */
    int updateSelective(SysMenu record);

    /**
     * 选择行update
     *
     * @param record record
     * @return status
     */
    int updateById(SysMenu record);

    /**
     * 通过用户信息获取权限
     *
     * @param id id
     * @return list
     */
    List<SysMenu> selectPermList(String id);

    /**
     * 为生成id获取数据
     *
     * @return list
     */
    List<SysMenu> selectOfParentAdd();

    /**
     * 获取数据
     *
     * @param menuEntity entity
     * @return list
     */
    List<SysMenu> selectByList(SysMenu menuEntity);

    /**
     * 获取所有可以打印的数据
     * @return list
     */
    List<SysMenu> selectListToExcel();

    List<SysMenu> selectListByIndex();
}