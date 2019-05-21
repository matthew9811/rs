package com.shengxi.system.model.service.sys;


import com.shengxi.system.common.constant.BaseControllerConstant;
import com.shengxi.system.common.util.TreeUtil;
import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.model.mapper.sys.SysMenuMapper;
import java.sql.SQLTransactionRollbackException;
import java.sql.SQLTransientException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> selectByInit() {
        List<SysMenuEntity> list = new ArrayList<>();
        SysMenuEntity menuEntity = new SysMenuEntity();
        menuEntity.setId("1");
        menuEntity.setDelFlag(BaseControllerConstant.DEL_FLAG_NOT);
        menuEntity.setIcon("&#xe6af;");
        menuEntity.setParentId("0");
        menuEntity.setMenuName("楚苓大妈网");
        menuEntity.setUrl("https://www.layui.com/doc/element/icon.html");
        list.add(menuEntity);
        menuEntity = new SysMenuEntity();
        menuEntity.setParentId("0");
        menuEntity.setId("3");
        menuEntity.setIcon("&#xe66e;");
        menuEntity.setMenuName("楚苓");
        list.add(menuEntity);
        menuEntity = new SysMenuEntity();
        menuEntity.setId("2");
        menuEntity.setIcon("&#xe715;");
        menuEntity.setParentId("1");
        menuEntity.setMenuName("大妈");
        menuEntity.setUrl("https://www.layui.com/doc/modules/layer.html");
        list.add(menuEntity);
        list = TreeUtil.Recursive(list);
        Map<String, Object> map = new HashMap<>();
        menuEntity = new SysMenuEntity();
        menuEntity.setId("4");
        menuEntity.setIcon("&#xe715;");
        menuEntity.setParentId("3");
        menuEntity.setMenuName("大妈");
        menuEntity.setUrl("https://www.layui.com/doc/modules/layer.html");
        list.add(menuEntity);
        map.put("data", list);
        map.put("msg","楚苓大妈牛逼");
        map.put("code", 0);
        return map;
    }

    /**
     * 返回用户的权限
     * @param id user_id
     * @return list
     */
    public List<SysMenuEntity> selectPermList(String id) {
        return sysMenuMapper.selectPermList(id);
    }
}
