/**
 *
 **/
(function ($) {
    /*jq扩展函数直接包含在内部的代码能直接使用jq扩展*/
    $.extend({
        //layer-table 模块
        table: {
            init: function (options) {
                var defaults = {
                    title: '',
                    url: ''
                };
                //传入两个对象。返回合并的值
                //defaults没有的属性，会增加
                //options有的会覆盖defaults
                var options = $.extend(defaults, options);
                var table = layer.table;
                table.render({
                    title: options.title,
                    url: options.url,
                })
            }
        },
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