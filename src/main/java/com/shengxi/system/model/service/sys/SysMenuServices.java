package com.shengxi.system.model.service.sys;


import com.shengxi.system.common.contant.BaseControllerContant;
import com.shengxi.system.common.util.TreeUtil;
import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.model.mapper.sys.SysMenuMapper;
import java.sql.SQLTransactionRollbackException;
import java.sql.SQLTransientException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    /**
     * 初始化获取
     */
    @Transactional(readOnly = true)
    public List<SysMenuEntity> selectByInit() {
        List<SysMenuEntity> list = new ArrayList<>();
        SysMenuEntity menuEntity = new SysMenuEntity();
        menuEntity.setId("1");
        menuEntity.setDelFlag(BaseControllerContant.DEL_FLAG_NOT);
        menuEntity.setIcon("&#xe6af;");
        menuEntity.setParentId("0");
        menuEntity.setMenuName("楚苓大妈网");
        menuEntity.setUrl("https://www.layui.com/doc/element/icon.html");
        menuEntity.setCreateTime(new Date("2018-08-25 08:36:55"));
        list.add(menuEntity);
        menuEntity.setParentId("0");
        menuEntity.setId("3");
        menuEntity.setIcon("&#xe66e;");
        menuEntity.setCreateTime(new Date("2018-08-25 08:38:59"));
        menuEntity.setMenuName("楚苓");
        list.add(menuEntity);
        menuEntity.setId("2");
        menuEntity.setIcon("&#xe715;");
        menuEntity.setParentId("1");
        menuEntity.setMenuName("大妈");
        menuEntity.setUrl("https://www.layui.com/doc/modules/layer.html");
        menuEntity.setCreateTime(new Date("2018-08-25 08:38:05"));
        list.add(menuEntity);
        list = TreeUtil.Recursive(list);
        return list;
    }
}
