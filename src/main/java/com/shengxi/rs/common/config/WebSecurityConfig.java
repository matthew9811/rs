package com.shengxi.rs.common.config;

import com.shengxi.rs.common.filter.TokenFilter;

import com.shengxi.rs.common.handler.RestAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 * @author: Matthew
 * @Date: 2019/4/26 15:08
 * @Description: 权限配置
 * 继承 WebSecurityConfigurerAdapter 实现权限的配置初始化
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenFilter tokenFilter;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private RestAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Value("${jwt.auth.path}")
    private String loginPath;
    /***
     * 数据加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置策略
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /**
         * 基于token, 关闭session
         */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
        /**
         * 开放资源
         */
        http.authorizeRequests().
                antMatchers(HttpMethod.POST, loginPath).anonymous()
                .antMatchers(HttpMethod.GET, "/").anonymous()
                .antMatchers(
                "/webjar/**", "/", "/**", "/*.html", "/favicon.ico", "/css/**", "/js/**", "/fonts/**", "/layui/**", "/img/**",
                "/v2/api-docs/**", "/swagger-resources/**", "/webjars/**", "/pages/**", "/druid/**",
                "/statics/**").permitAll().anyRequest().authenticated();
        /**
         * 权限配置
         */
        http.formLogin().usernameParameter("userNo");
        /*登录页面和登录提交路径*/
        http.formLogin().usernameParameter("userNo").
                loginProcessingUrl("/login").
                successHandler(authenticationSuccessHandler).
                failureHandler(authenticationFailureHandler).and()
                /*自定义权限拒绝处理类*/
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler).
                authenticationEntryPoint(authenticationEntryPoint);
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
        http.headers().frameOptions().disable();
        http.headers().cacheControl();
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
