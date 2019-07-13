package com.shengxi.system.model.service.sys.impl;

import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.rs.common.util.UserUtil;
import com.shengxi.system.entites.sys.SysData;
import com.shengxi.system.model.mapper.sys.SysDataMapper;
import com.shengxi.system.model.service.sys.SysDictDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author matthew
 * @version 1.0.0
 * @Description: 字典数据服务层实现类
 * @see SysDictDataService
 */
@Service("dictData")
public class SysDictDataServiceImpl implements SysDictDataService {

    private SysDataMapper dataMapper;

    @Override
    public List<SysData> selectDictDataListByDictId(SysData sysData) {
        return dataMapper.selectDictDataListByDictId(sysData);
    }

    @Override
    public Integer insert(SysData sysData) {
        sysData.setCreateBy(UserUtil.getUserNo());
        sysData.setId(IdUtil.uuid());
        return dataMapper.insert(sysData);
    }

    @Autowired
    public void setDataMapper(SysDataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }
}
