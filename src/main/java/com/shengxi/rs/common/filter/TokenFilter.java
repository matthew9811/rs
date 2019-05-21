package com.shengxi.rs.common.filter;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.rs.common.services.TokenService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Token过滤器
 * 完成访问前的过滤
 * @author matthew
 */
@Component
public class TokenFilter extends OncePerRequestFilter {

    public static final String TOKEN_KEY = "token";

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserDetailsService userDetailsService;

    private static final Long MINUTES_10 = 10 * 60 * 1000L;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getToken(request);
        if (StringUtils.isNotBlank(token)) {
            SecurityUser securityUser = tokenService.getSecurityUser(token);
            if (ObjectUtil.isNotNull(securityUser)) {
                securityUser = checkLoginTime(securityUser);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser,
                        null, securityUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 校验时间<br>
     * 过期时间与当前时间对比，临近过期10分钟内的话，自动刷新缓存
     *
     * @param securityUser 当前验证用户
     * @return securityUser 验证后的用户
     */
    private SecurityUser checkLoginTime(SecurityUser securityUser) {
        long expireTime = securityUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MINUTES_10) {
            String token = securityUser.getToken();
            securityUser = (SecurityUser) userDetailsService.loadUserByUsername(securityUser.getUserNo());
            securityUser.setToken(token);
            tokenService.refresh(securityUser);
        }
        return securityUser;
    }

    /**
     * 根据参数或者header获取token
     *
     * @param request 请求
     * @return token
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getParameter(TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getHeader(TOKEN_KEY);
        }

        return token;
    }
}
