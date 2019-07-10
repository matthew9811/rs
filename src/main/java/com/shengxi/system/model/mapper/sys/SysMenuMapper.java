package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     * 通过id查询
     *
     * @param id id
     * @return status
     */
    SysMenu selectById(String id);


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
     * 插入菜单 强制插入
     *
     * @param record record
     * @return status
     */
    Integer insert(SysMenu record);

    /**
     * 选择行插入
     *
     * @param record record
     * @return status
     */
    Integer insertSelective(SysMenu record);

    /**
     * 整体update
     *
     * @param record record
     * @return status
     */
    Integer updateSelective(SysMenu record);

    /**
     * 选择行update
     *
     * @param record record
     * @return status
     */
    Integer updateById(SysMenu record);

    /**
     * 根据id删除数据
     * 传入待删除数据的id和本次操作的操作人
     * 修改数据删除状态，记录操作人
     *
     * @param id       userId
     * @param updateBy updateBy
     * @return status
     */
    Integer deleteById(@Param("id") String id, @Param("updateBy") String updateBy);


}