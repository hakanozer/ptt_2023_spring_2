package com.works.configs;

import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@RequiredArgsConstructor
public class BeforFilter extends GenericFilterBean {

    final InfoRepository infoRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth != null ? auth.getName() : "globalUser";
        String roles = auth != null ? auth.getAuthorities().toString() : "globalRole";
        String sessionID = req.getSession().getId();
        String ip = req.getRemoteAddr();
        String agent = req.getHeader("user-agent");
        long time = System.currentTimeMillis();

        Info i = new Info(url, userName, roles, sessionID, ip, agent,time);
        infoRepository.save(i);

        chain.doFilter(req, res);
    }

}
