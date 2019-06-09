package com.shengxi.system.model.service.sys.impl;

import cn.hutool.core.convert.Convert;
import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.rs.common.util.UserUtil;
import com.shengxi.system.common.constant.ServiceConstant;
import com.shengxi.system.entites.sys.SysDict;
import com.shengxi.system.model.mapper.sys.SysDataMapper;
import com.shengxi.system.model.mapper.sys.SysDictMapper;
import com.shengxi.system.model.service.sys.SysDictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字典普通实现类
 *
 * @author matthew
 * @date 2019.06.06
 */
@Service(value = "sysDict")
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
    public List<SysDict> selectSysDictList(SysDict sysDict) {
        return dictMapper.selectDictByList(sysDict);
    }

    @Override
    public Integer insertSysDict(SysDict sysDict) {
        sysDict.setId(IdUtil.uuid());
        sysDict.setCreateBy(UserUtil.getUserNo());
        sysDict.setStatus(ServiceConstant.NORMAL);
        return dictMapper.insert(sysDict);
    }

    @Override
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
        return dictMapper.deleteByPrimaryKey(id, UserUtil.getUserNo());
    }

    @Override
    public Integer deleteSysDictByIds(String ids) {
        return dictMapper.deleteByIdList(Convert.toStrArray(ids), UserUtil.getUserNo());
    }
}
