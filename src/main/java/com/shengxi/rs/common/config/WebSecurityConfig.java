package com.shengxi.rs.common.config;

import com.shengxi.rs.common.filter.TokenFilter;
import javax.servlet.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
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
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

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
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /**
         * 开放资源
         */
        http.authorizeRequests().antMatchers("/", "/**", "/*.html", "/*.ico", "/css/**", "/js/**", "/fonts/**", "/layui/**", "/img/**",
                "/webjar/**", "/druid/**", "/static/**", "/", "/**", "/*.html", "/favicon.ico", "/css/**", "/js/**", "/fonts/**", "/layui/**", "/img/**",
                "/v2/api-docs/**", "/swagger-resources/**", "/webjars/**", "/pages/**", "/druid/**",
                "/statics/**").permitAll().anyRequest().authenticated();
        /**
         * 权限配置
         */
        http.addFilterBefore((Filter) tokenFilter, UsernamePasswordAuthenticationFilter.class);
        /*登录页面和登录提交路径*/
        http.formLogin().loginProcessingUrl("/login").successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
        http.headers().frameOptions().disable();
        http.headers().cacheControl();
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }



}
