package com.shengxi.rs.common.config;


import com.shengxi.rs.common.interceptor.LoginInterceptor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author matthew
 */
@Deprecated
//@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    private List<String> excludePathPatternList;

    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     *
     * @param registry 注册管理
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(getUrls());
        super.addInterceptors(registry);
    }


    /**
     * 这个方法是用来配置静态资源的，比如html，js，css，等等
     *
     * @param registry 注册管理
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 定义需要避免过滤的url
     *
     * @return list
     */
    private List<String> getUrls() {
        List<String> list = new ArrayList<>();
        /**
         * "/webjar/**", "/", "/**", "/*.html", "/favicon.ico", "/css/**", "/js/**", "/fonts/**", "/layui/**", "/img/**",
         *                 "/v2/api-docs/**", "/swagger-resources/**", "/webjars/**", "/pages/**", "/druid/**",
         *                 "/statics/**"
         */
        list.add("/webjar/**");
        list.add("/");
        list.add("/**");
        list.add("/*.html");
        list.add("/css/**");
        list.add("/js/**");
        list.add("/fonts/**");
        list.add("/layui/**");
        list.add("/img/**");
        list.add("/v2/api-docs/**");
        list.add("/webjars/**");
        list.add("/pages/**");
        list.add("/druid/**");
        list.add("/statics/**");
        this.setExcludePathPatternList(list);
        return excludePathPatternList;
    }

    public void setExcludePathPatternList(List<String> excludePathPatternList) {
        this.excludePathPatternList = excludePathPatternList;
    }
}
