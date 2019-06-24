(function ($) {
    layui.config({
        base: '/layui/lay/modules/'
    }).extend({
        treetable: 'treetable-lay/treetable',
        authtree: 'layui_exts/authtree'
    });

    layui.use(['laydate'], function () {
        var laydate = layui.laydate;
        if ($(".layer-range-time").length > 0) {

            laydate.render({
                elem: '#time',
                type: 'datetime',
                range: '~',
                format: 'yyyy-MM-dd HH:mm:ss',
                calendar: true,
                done: function (value) {
                }
            });

        }
    });

})(jQuery);

(function ($) {
    /*jq扩展函数直接包含在内部的代码能直接使用jq扩展*/

    $.extend({
        modal: {
            ajax : function (config) {
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

                    },
                    error: function () {

                    }
                };
                var config = $.extend(defaults, config);
                $.ajax({
                    url: config.url,
                    type: config.type,
                    timeout: config.timeout,
                    async: config.async,
                    cache: config.cache,
                    data: config.data,
                    dataType: config.dataType,
                    contentType: config.contentType,
                    success: config.success,
                    error: config.error
                })
            }
        },

        popup: {
            hint: function (options) {
                var defaults = {
                    msg: '',
                    icon: ''
                };
                var options = $.extend(defaults, options);
                layui.use('layer',function () {
                    var $ = layui.jquery, layer = layui.layer;
                    layer.msg(options.msg, {icon: options.icon});
                })
            }
        }

    })

})(jQuery);