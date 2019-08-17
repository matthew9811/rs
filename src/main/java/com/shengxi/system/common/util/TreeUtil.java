package com.shengxi.system.common.util;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.entity.config.Tree;
import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构工具类
 *
 * @author matthew
 * @date 2019.05.13
 */
public class TreeUtil {

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
