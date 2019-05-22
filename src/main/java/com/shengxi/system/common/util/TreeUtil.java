package com.shengxi.system.common.util;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.constant.SysConstant;
import com.shengxi.rs.common.domain.Tree;
import com.shengxi.rs.common.util.StringUtils;
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

    public static <T> Tree<T> build(List<Tree<T>> nodes) {
        if (ObjectUtil.isNull(nodes)) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach(children -> {
            String pid = children.getParentId();
            if (pid == null || SysConstant.NORMAL.equals(pid)) {
                topNodes.add(children);
                return;
            }
            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setChildren(true);
                    return;
                }
            }
        });

        Tree<T> root = new Tree<>();
        root.setId("0");
        root.setParentId("");
        root.setHasParent(false);
        root.setChildren(true);
        root.setChecked(true);
        root.setChildren(topNodes);
        root.setText("根节点");
        Map<String, Object> state = new HashMap<>(16);
        state.put("opened", true);
        root.setState(state);
        return root;
    }

    public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
        if (ObjectUtil.isNull(nodes)) {
            return new ArrayList<>();
        }
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach(children -> {
            String pid = children.getParentId();
            if (StringUtils.isNull(pid) || idParam.equals(pid)) {
                topNodes.add(children);
                return;
            }
            nodes.forEach(parent -> {
                String id = parent.getId();
                if (StringUtils.isNotNull(id) && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setChildren(true);
                }
            });
        });
        return topNodes;
    }
}
