/**
 *
 **/
(function ($) {
    /*jq扩展函数直接包含在内部的代码能直接使用jq扩展*/

    $.extend({
        /*layer-table 模块*/
        table: {
            init: function (options) {
                var defaults = {
                    title: '',
                    url: '',
                    cellMinWidth: 95,
                    page: true,
                    height: "full-125",
                    limit: 10,
                    limits: [10, 20, 50, 100],
                    // where: {},
                    response: {
                        statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
                    },
                    parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
                        return {
                            "code": res.code, //解析接口状态
                            "msg": res.msg, //解析提示文本
                            "count": res.count, //解析数据长度
                            "data": res.data //解析数据列表
                        };
                    }
                };
                //传入两个对象。返回合并的值
                //defaults没有的属性，会增加
                //options有的会覆盖defaults
                var options = $.extend(defaults, options);
                layui.use(['table'], function () {
                    var table = layui.table;
                    table.render({
                        elem: options.elem,
                        url: options.url,
                        title: options.title,
                        toolbar: options.toolbar, //开启工具栏
                        page: options.page,
                        where: options.where,
                        response: options.response,
                        parseData: options.parseData,
                        cols: options.cols
                    })
                })
            },

            edit: function (tableId) {
                layui.use(['table'], function () {
                    var table = layui.table;
                    table.on("edit(" + tableId + ")", function (obj) {
                        return obj;
                    })
                })
            },

            checkbox: function (tableId) {
                layui.use(['table'], function () {
                    var table = layui.table;
                    table.on('checkbox(' + tableId + ')', function (obj) {
                        return obj;
                    });
                })
            }
        },

        /*treeTable 模块*/
        treeTable: {
            init: function (options) {
                var defaults = {
                    treeColIndex: 1,
                    treeSpid: 0,
                    treeIdName: 'id',
                    treePidName: 'parentId',
                    treeDefaultClose: true,   // 是否默认折叠
                    treeLinkage: true,        // 父级展开时是否自动展开所有子级
                    treeShowName: 'name',
                    elem: '#treeTable',
                    url: '',
                    page: false,
                    response: {
                        statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
                    },
                    parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
                        return {
                            "code": res.code, //解析接口状态
                            "msg": res.msg, //解析提示文本
                            // "count": res.count, //解析数据长度
                            "data": res.data //解析数据列表
                        };
                    }
                };
                var options = $.extend(defaults, options);
                layui.use(['treetable'], function () {
                    var $ = layui.jquery;
                    var treeTable = layui.treetable;
                    treeTable.render({
                        treeColIndex: options.treeColIndex,
                        treeSpid: options.treeSpid,
                        treeIdName: options.treeIdName,
                        treePidName: options.treePidName,
                        treeDefaultClose: options.treeDefaultClose,   // 是否默认折叠
                        treeLinkage: options.treeLinkage,        // 父级展开时是否自动展开所有子级
                        treeShowName: options.treeShowName,
                        elem: options.elem,
                        url: options.url,
                        page: options.page,
                        response: options.response,
                        parseData: options.parseData,
                        cols: options.cols
                    });
                })

            },

            btn: function () {
                layui.use(['treetable'], function () {
                    var $ = layui.jquery;
                    var treeTable = layui.treetable;
                    $('#btn-expand').click(function () {
                        treeTable.expandAll('#treeTable');
                    });
                    $('#btn-fold').click(function () {
                        treeTable.foldAll('#treeTable');
                    });
                })

            }
        },

        /*tree 模块*/
        tree: {
            init: function (options) {
                var defaults = {
                    title: '',
                    url: '',
                    cellMinWidth: 95,
                    page: true,
                    height: "full-125",
                    limit: 10,
                    limits: [10, 20, 50, 100],
                    response: {
                        statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
                    },
                    parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
                        return {
                            "code": res.code, //解析接口状态
                            "msg": res.msg, //解析提示文本
                            "count": res.count, //解析数据长度
                            "data": res.data //解析数据列表
                        };
                    },
                };
                var options = $.extend(defaults, options);
                layui.tree({
                    elem: options.elem,
                    nodes: options.nodes
                });

            }
        },

        /*提示层*/
        pop: {
            // 自行传参
            init: function (options) {
              $.popup.hint(options)
            },
            //成功提示
            success: function (options) {
                var defaults = {
                    msg: "操作成功",
                    icon: 1
                };
                var options = $.extend(defaults, options);
                $.popup.hint(options);
            },
            //错误提示
            error: function (options) {
                var defaults = {
                    msg: "操作错误",
                    icon: 2
                };
                var options = $.extend(defaults, options);
                $.popup.hint(options);
            },
            //警告提示
            warn: function (options) {
                var defaults = {
                    msg: "操作不规范",
                    icon: 8
                };
                var options = $.extend(defaults, options);
                $.popup.hint(options);
            }
        },

        /*ajax提交*/
        submit: {
            /*插入提交*/
            addSubmit: function (options) {
                var defaults = {
                    url: "/",
                    type: "post",
                    timeout: 60000,
                    async: true,
                    cache: true,
                    data: {},
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded",
                    success: function (data) {
                        $.pop.success(data.msg);
                        parent.location.reload();
                    },
                    error: function () {
                        $.pop.error()
                    }
                };
                var options = $.extend(defaults, options);
                $.modal.ajax(options);
            },

            /*编辑提交*/
            editSubmit: function (options) {
                var defaults = {
                    url: "/",
                    type: "post",
                    timeout: 60000,
                    async: true,
                    cache: true,
                    data: {},
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded",
                    success: function () {
                        $.pop.success({msg: '修改成功'});
                        parent.location.reload();
                    },
                    error: function () {
                        $.pop.error()
                    }
                };
                var options = $.extend(defaults, options);
                $.modal.ajax(options);
            },

            /*删除提交*/
            moveSubmit: function (options) {
                var defaults = {
                    url: "/",
                    type: "post",
                    timeout: 60000,
                    async: true,
                    cache: true,
                    data: {},
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded",
                    success: function () {
                        $.pop.success({msg: '删除成功'});
                        parent.location.reload()
                    },
                    error: function () {
                        $.pop.error()
                    }
                };
                var options = $.extend(defaults, options);
                $.modal.ajax(options);
            }
        }


    })

})(jQuery);

/** 消息状态码 */
web_status = {
    SUCCESS: 0,
    FAIL: 500,
    WARNING: 301
};

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};