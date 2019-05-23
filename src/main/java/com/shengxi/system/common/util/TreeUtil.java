package com.shengxi.system.common.util;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.constant.SysConstant;
import com.shengxi.rs.common.domain.Tree;
import com.shengxi.rs.common.util.StringUtils;
import com.shengxi.system.entites.sys.SysMenuEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构工具类
 *
 * @author matthew
 * @date 2019.05.13
 */
public class TreeUtil {

    public static <T> List<Tree<T>> Recursive(List<Tree<T>> trees) {
        List<Tree<T>> list = new ArrayList<>();
        trees.forEach((obj) -> {
            list.add(findChild(obj, trees));
        });
        return list;
    }

    /**
     * 查找对子结点
     *
     * @param node      node
     * @param treeNodes tree
     * @return entity
     */
    private static <T> Tree<T> findChild(Tree<T> node, List<Tree<T>> treeNodes) {
        for (Tree<T> vo : treeNodes) {
            if (vo.getId().equals(node.getParentId())) {
                if (ObjectUtil.isNull(node.getChildren())) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(findChild(vo, treeNodes));
            }
        }
        return node;
    }

    private static <T> Tree<T> find(Tree<T> node, List<Tree<T>> treeNodes) {
        for (Tree<T> vo : treeNodes) {
            if (node.getId().equals(vo.getParentId())) {
                node.getChildren().add(vo);
                treeNodes.remove(vo);
                for (Tree<T> child : node.getChildren()) {
                    find(child, treeNodes);
                }
            }
        }
        return node;
    }
}
