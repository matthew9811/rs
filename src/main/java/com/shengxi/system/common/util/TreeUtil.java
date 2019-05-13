package com.shengxi.system.common.util;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.Tree;
import com.shengxi.system.entites.sys.SysMenuEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构工具类
 *
 * @author matthew
 * @date 2019.05.13
 */
public class TreeUtil {

    public static List<SysMenuEntity> Recursive(List<SysMenuEntity> trees){
        ArrayList<SysMenuEntity> sysMenuEntities = new ArrayList<>();
        for (SysMenuEntity vo: trees){
            sysMenuEntities.add(findChild(vo, trees));
        }
        return sysMenuEntities;
    }


    /**
     * 查找对子结点
     * @param node node
     * @param treeNodes tree
     * @return entity
     */
    public static SysMenuEntity findChild(SysMenuEntity node, List<SysMenuEntity> treeNodes) {
        for (SysMenuEntity vo : treeNodes) {
            if (vo.getId().equals(node.getParentId())) {
                if (ObjectUtil.isNull(node.getChild())) {
                    node.setChild(new ArrayList<>());
                }
                node.getChild().add(findChild(vo, treeNodes));
            }
        }
        return node;
    }
}
