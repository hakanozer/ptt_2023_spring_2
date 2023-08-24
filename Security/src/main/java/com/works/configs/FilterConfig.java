package com.works.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Configuration
public class FilterConfig implements Filter {


    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("App UP");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String roles = auth.getAuthorities().toString();
        String sessionID = req.getSession().getId();
        String ip = req.getRemoteAddr();
        String agent = req.getHeader("user-agent");
        long time = System.currentTimeMillis();

        System.out.println( url + " " + userName+ " " +roles+ " " +sessionID+ " " +ip+ " " +agent+ " " +time );
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("App Down");
    }
}
