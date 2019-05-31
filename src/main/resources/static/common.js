$(function () {
    layui.config({
        base: '/layui/lay/modules'
    }).extend({
        treetable: '/treetable-lay/treetable',
        authtree: '/layui_exts/authtree'
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

})