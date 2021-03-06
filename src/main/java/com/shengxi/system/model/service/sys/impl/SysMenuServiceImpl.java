package com.shengxi.system.model.service.sys.impl;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.entity.config.Tree;
import com.shengxi.system.common.util.IdUtil;
import com.shengxi.system.common.constant.BaseConstant;
import com.shengxi.system.common.constant.ServiceConstant;
import com.shengxi.system.entity.sys.SysMenu;
import com.shengxi.system.model.mapper.sys.SysMenuMapper;

import com.shengxi.system.model.service.sys.SysMenuService;

import java.sql.SQLTransactionRollbackException;
import java.sql.SQLTransientException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.select.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜单服务层
 *
 * @author matthew
 */
@Service("menu")
@Transactional(readOnly = false, rollbackFor = SQLTransientException.class)
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Override
    @Transactional(readOnly = false, rollbackFor = SQLTransactionRollbackException.class)
    public Integer insertEntity(SysMenu sysMenu) {
        sysMenu = judgeParent(sysMenu);
        /* 控制del_flag*/
        sysMenu.setDelFlag(BaseConstant.DEL_FLAG_NOT);
        sysMenu.setId(IdUtil.uuid());
        return sysMenuMapper.insert(sysMenu);
    }

    /**
     * 初始化获取
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Selector.SelectorParseException.class)
    public Map<String, Object> selectByInit(SysMenu menuEntity) {
        List<SysMenu> list = sysMenuMapper.selectByList(menuEntity);
        System.out.println(list.toString());
        Map map = new HashMap(list.size());
        map.put("msg", "刷新成功!");
        map.put("data", list);
        map.put("code", 200);
        return map;
    }

    /**
     * 返回用户的权限
     *
     * @param id user_id
     * @return list
     */
    @Override
    public List<SysMenu> selectPermList(String id) {
        return sysMenuMapper.selectPermList(id);
    }

    /**
     * 获取对应的菜单id + name
     *
     * @return list
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<SysMenu> selectOfParentAdd() {
        return sysMenuMapper.selectOfParentAdd();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> selectByList() {
        return sysMenuMapper.selectByList(new SysMenu());
    }

    @Override
    @Transactional(readOnly = true)
    public SysMenu selectMenuById(String id) {
        return sysMenuMapper.selectById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Integer deleteById(String id, String userNo) {
        return sysMenuMapper.deleteById(id, userNo);
    }

    /**
     * 判断是否有父类id
     *
     * @param sysMenu menu
     * @return menuEntity
     */
    private SysMenu judgeParent(SysMenu sysMenu) {
        if (ObjectUtil.isNull(sysMenu.getParentId())) {
            sysMenu.setParentId("0");
        }
        return sysMenu;
    }

}
