package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 字典数据mapper
 *
 * @see SysDataMapper
 * @author matthew
 * @date 2019.06.06
 * @version 1.0.0
 */
@Repository
@Mapper
public interface SysDataMapper {

    /**********读操作***********/
    /**
     * 根据id获取数据
     *
     * @param id id
     * @return sysData
     */
    SysData selectByPrimaryKey(String id);

    /***********写操作***********/
    /**
     * 完整插入
     *
     * @param record record
     * @return status
     */
    int insert(com.shengxi.system.entites.sys.SysData record);

    /**
     * 动态插入
     *
     * @param record record
     * @return status
     */
    int insertSelective(com.shengxi.system.entites.sys.SysData record);

    /**
     * 动态update
     *
     * @param record record
     * @return status
     */
    int updateByPrimaryKeySelective(com.shengxi.system.entites.sys.SysData record);

    /**
     * update
     *
     * @param record record
     * @return status
     */
    int updateByPrimaryKey(com.shengxi.system.entites.sys.SysData record);

    /**
     * 删除数据
     *
     * @param id       id
     * @param updateBy userNo
     * @return status
     */
    int deleteByPrimaryKey(@Param("id") String id, @Param("updateBy") String updateBy);
}