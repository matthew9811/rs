package com.shengxi.system.model.service.sys.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.common.util.IdUtil;
import com.shengxi.system.common.util.UserUtil;
import com.shengxi.system.common.constant.ServiceConstant;
import com.shengxi.system.entity.sys.SysData;
import com.shengxi.system.entity.sys.SysDict;
import com.shengxi.system.model.mapper.sys.SysDataMapper;
import com.shengxi.system.model.mapper.sys.SysDictMapper;
import com.shengxi.system.model.service.sys.SysDictService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字典普通实现类
 *
 * @author matthew
 * @date 2019.06.06
 */
@Service(value = "dict")
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper dictMapper;

    @Autowired
    private SysDataMapper dataMapper;


    @Override
    public SysDict selectSysDictById(String id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<SysDict> selectSysDictList(SysDict sysDict) {
        return dictMapper.selectDictByList(sysDict);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public Integer insertSysDict(SysDict sysDict) {
        sysDict.setCreateBy(UserUtil.getUserNo());
        sysDict.setStatus(ServiceConstant.NORMAL);
        return dictMapper.insert(sysDict);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT)
    public Integer updateSysDict(SysDict sysDict) {
        sysDict.setUpdateBy(UserUtil.getUserNo());
        return dictMapper.updateByPrimaryKey(sysDict);
    }

    @Override
    public Integer updateByIdSelective(SysDict sysDict) {
        sysDict.setUpdateBy(UserUtil.getUserNo());
        return dictMapper.updateByPrimaryKeySelective(sysDict);
    }

    @Override
    public Integer deleteSysDictById(String id) {
        return dictMapper.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public Integer deleteSysDictByIds(String ids) {
        return dictMapper.deleteByIdList(Convert.toStrArray(ids));
    }

    public List<SysData> getValue(String typeNo) {
        return dataMapper.getValue(typeNo);
    }

}
