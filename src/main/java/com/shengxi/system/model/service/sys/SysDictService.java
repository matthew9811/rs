package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.sys.SysDict;
import java.util.List;

/**
 * 字典服务接口
 * @author matthew
 */
public interface SysDictService {

    /**
     * 根据id获取record
     * @param id id
     * @return record
     */
    SysDict selectSysDictById(String id);

    /**
     * 动态获取list
     * @param sysDict record
     * @return list
     */
    List<SysDict> selectSysDictList(SysDict sysDict);

    /**
     * 插入数据
     * @param sysDict record
     * @return status
     */
    Integer insertSysDict(SysDict sysDict);

    /**
     * 全局更新数据
     * @param sysDict record
     * @return status
     */
    Integer updateSysDict(SysDict sysDict);

    /**
     * 动态更新
     * @param sysDict record
     * @return status
     */
    Integer updateByIdSelective(SysDict sysDict);

    /**
     * 删除
     * @param id id
     * @return status
     */
    Integer deleteSysDictById(String id);

    /**
     * 批量删除
     * @param ids ids
     * @return status
     */
    Integer deleteSysDictByIds(String ids);
}
