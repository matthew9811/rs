package com.shengxi.system.model.service.sys.impl;

import com.shengxi.system.common.util.UserUtil;
import com.shengxi.system.common.constant.ServiceConstant;
import com.shengxi.system.entity.sys.SysData;
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
        sysData.setStatus(ServiceConstant.NORMAL);
        sysData.setCreateBy(UserUtil.getUserNo());
        synchronized (this){
            sysData.setTypeCode(this.getNum());
        }
        return dataMapper.insert(sysData);
    }

    @Override
    public Integer deleteById(String id) {
        return dataMapper.deleteById(id);
    }

    @Autowired
    public void setDataMapper(SysDataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    /**
     * 获取当前的编号
     *
     * @return num String
     */
    private String getNum() {
        String num = dataMapper.getNum();
        return num.equals("0") ? "1" : String.valueOf(Integer.valueOf(num) + 1);
    }
}
