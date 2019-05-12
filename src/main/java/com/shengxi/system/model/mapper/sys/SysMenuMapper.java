package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单接口
 * @author matthew
 */
@Mapper
public interface SysMenuMapper {


    /**
     * 插入菜单 强制插入
     * @param record
     * @return status
     */
    int insert(SysMenuEntity record);

    /**
     * 选择行插入
     * @param record
     * @return status
     */
    int insertSelective(SysMenuEntity record);

    /**
     * 通过id查询
     * @param id
     * @return status
     */
    SysMenuEntity selectById(String id);

    /**
     * 整体update
     * @param record
     * @return status
     */
    int updateSelective(SysMenuEntity record);

    /**
     * 选择行update
     * @param record
     * @return status
     */
    int updateById(SysMenuEntity record);
}