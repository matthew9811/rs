package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysMenuEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单接口
 * @author matthew
 */
@Mapper
public interface SysMenuMapper {


    /**
     * 插入菜单 强制插入
     * @param record record
     * @return status
     */
    int insert(SysMenuEntity record);

    /**
     * 选择行插入
     * @param record record
     * @return status
     */
    int insertSelective(SysMenuEntity record);

    /**
     * 通过id查询
     * @param id id
     * @return status
     */
    SysMenuEntity selectById(String id);

    /**
     * 整体update
     * @param record record
     * @return status
     */
    int updateSelective(SysMenuEntity record);

    /**
     * 选择行update
     * @param record record
     * @return status
     */
    int updateById(SysMenuEntity record);

    /**
     * 通过用户信息获取权限
     * @param id id
     * @return list
     */
    List<SysMenuEntity> selectPermList(String id);

    /**
     * 为生成id获取数据
     * @return list
     */
    List<SysMenuEntity> selectOfParentAdd();

    /**
     * 获取数据
     * @param menuEntity entity
     * @return list
     */
    List<SysMenuEntity> selectByList(SysMenuEntity menuEntity);
}