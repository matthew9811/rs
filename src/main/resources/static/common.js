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
            ajax: function (config) {
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
                layui.use('layer', function () {
                    var $ = layui.jquery, layer = layui.layer;
                    layer.msg(options.msg, {icon: options.icon});
                })
            }
        }

    })

})(jQuery);

/**
 * 测试版本，测定无效
 */
/** 创建选项卡 */
function createMenuItem(dataUrl, menuName) {
    var panelUrl = window.frameElement.getAttribute('data-id');
    dataIndex = $.common.random(1, 100),
        flag = true;
    if (dataUrl == undefined || $.trim(dataUrl).length == 0) return false;
    var topWindow = $(window.parent.document);
    // 选项卡菜单已存在
    $('.menuTab', topWindow).each(function () {
        if ($(this).data('id') == dataUrl) {
            if (!$(this).hasClass('active')) {
                $(this).addClass('active').siblings('.menuTab').removeClass('active');
                $('.page-tabs-content').animate({marginLeft: ""}, "fast");
                // 显示tab对应的内容区
                $('.mainContent .RuoYi_iframe', topWindow).each(function () {
                    if ($(this).data('id') == dataUrl) {
                        $(this).show().siblings('.RuoYi_iframe').hide();
                        return false;
                    }
                });
            }
            flag = false;
            return false;
        }
    });
    // 选项卡菜单不存在
    if (flag) {
        var str = '<a href="javascript:;" class="active menuTab" data-id="' + dataUrl + '" data-panel="' + panelUrl + '">' + menuName + ' <i class="fa fa-times-circle"></i></a>';
        $('.menuTab', topWindow).removeClass('active');

        // 添加选项卡对应的iframe
        var str1 = '<iframe class="RuoYi_iframe" name="iframe' + dataIndex + '" width="100%" height="100%" src="' + dataUrl + '" frameborder="0" data-id="' + dataUrl + '" data-panel="' + panelUrl + '" seamless></iframe>';
        $('.mainContent', topWindow).find('iframe.RuoYi_iframe').hide().parents('.mainContent').append(str1);

        window.parent.$.modal.loading("数据加载中，请稍后...");
        $('.mainContent iframe:visible', topWindow).load(function () {
            window.parent.$.modal.closeLoading();
        });

        // 添加选项卡
        $('.menuTabs .page-tabs-content', topWindow).append(str);
    }
    return false;
}

/** 刷新选项卡 */
var refreshItem = function () {
    var topWindow = $(window.parent.document);
    var currentId = $('.page-tabs-content', topWindow).find('.active').attr('data-id');
    var target = $('.RuoYi_iframe[data-id="' + currentId + '"]', topWindow);
    var url = target.attr('src');
    target.attr('src', url).ready();
}

/** 关闭选项卡 */
var closeItem = function (dataId) {
    var topWindow = $(window.parent.document);
    if ($.common.isNotEmpty(dataId)) {
        window.parent.$.modal.closeLoading();
        // 根据dataId关闭指定选项卡
        $('.menuTab[data-id="' + dataId + '"]', topWindow).remove();
        // 移除相应tab对应的内容区
        $('.mainContent .RuoYi_iframe[data-id="' + dataId + '"]', topWindow).remove();
        return;
    }
    var panelUrl = window.frameElement.getAttribute('data-panel');
    $('.page-tabs-content .active i', topWindow).click();
    if ($.common.isNotEmpty(panelUrl)) {
        $('.menuTab[data-id="' + panelUrl + '"]', topWindow).addClass('active').siblings('.menuTab').removeClass('active');
        $('.mainContent .RuoYi_iframe', topWindow).each(function () {
            if ($(this).data('id') == panelUrl) {
                $(this).show().siblings('.RuoYi_iframe').hide();
                return false;
            }
        });
    }
}

