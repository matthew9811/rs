package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysDict;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 字典mapper
 *
 * @author matthew
 * @date 2019.06.06
 */
@Repository
@Mapper
public interface SysDictMapper {

    /**
     * 根据id获取对应的对象
     *
     * @param id id
     * @return sysDict
     */
    SysDict selectByPrimaryKey(String id);

    /**
     * 动态selectList
     *
     * @param sysDict record
     * @return list
     */
    List<SysDict> selectDictByList(SysDict sysDict);
    /**
     * 当前字典的值
     *
     * @return num
     */
    Integer checkNo();

    /**
     * 删除对应的字典
     *
     * @param id       id
     * @param updateBy updateBy
     * @return status
     */
    int deleteByPrimaryKey(@Param("id") String id, @Param("updateBy") String updateBy);

    /**
     * 全对象插入数据
     *
     * @param record record
     * @return status
     */
    int insert(SysDict record);

    /**
     * 动态插入数据
     * 允许插入部分数据
     *
     * @param record record
     * @return status
     */
    int insertSelective(SysDict record);

    /**
     * 动态更新数据（注意update null 值）
     *
     * @param record record
     * @return status
     */
    int updateByPrimaryKeySelective(SysDict record);

    /**
     * 根据id更新完整数据
     *
     * @param record record
     * @return status
     */
    int updateByPrimaryKey(SysDict record);

    /**
     * 批量删除
     *
     * @param idArr  ids
     * @param userNo updateBy
     * @return status
     * @Description: 删除对应ID的数据
     */
    Integer deleteByIdList(String[] idArr, @Param("updateBy") String userNo);
}