package com.shengxi.system.model.service.sys;

import com.shengxi.system.entity.sys.SysData;

import java.util.List;

/**
 * @author matthew
 * @version 1.0.0
 * @Description: 字典数据服务层
 * @Date: 2019.06.09
 * @see SysDictDataService
 */
public interface SysDictDataService {

    /**
     * 查询数据
     *
     * @param sysData sysData
     * @return list
     */
    List<SysData> selectDictDataListByDictId(SysData sysData);


    /**
     * 插入data
     *
     * @param sysData bean
     * @return status
     */
    Integer insert(SysData sysData);

    /**
     * @param typeNo typeNo
     * @return typeNo
     */
    Integer deleteByTypeNo(String typeNo);
}
