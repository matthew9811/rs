package com.shengxi.system.model.service.sys;


import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.model.mapper.sys.SysMenuMapper;
import java.sql.SQLTransactionRollbackException;
import java.sql.SQLTransientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜单服务层
 * @author matthew
 */
@Service("menu")
@Transactional(readOnly = false, rollbackFor = SQLTransientException.class)
public class SysMenuServices {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Transactional(readOnly = false, rollbackFor = SQLTransactionRollbackException.class)
    public Integer insertEntity(SysMenuEntity sysMenuEntity) {
        return sysMenuMapper.insert(sysMenuEntity);
    }
}
