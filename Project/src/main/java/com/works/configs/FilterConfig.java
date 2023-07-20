package com.works.configs;

import com.works.entities.Customer;
import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final InfoRepository infoRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String[] freeUrls = {"/customer/register", "/customer/login"};
        boolean loginStatus = true;
        for( String item : freeUrls ) {
            if(item.equals(url)) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            boolean status = req.getSession().getAttribute("customer") == null;
            if (status) {
                // Session Empty!
                PrintWriter printWriter = res.getWriter();
                String errorJson = "{ \"status\": false, \"result\": \"Please Login!\" }";
                printWriter.println(errorJson);
                res.setContentType("application/json");
                res.setStatus(HttpStatus.UNAUTHORIZED.value());
            }else {
                String sessionId = req.getSession().getId();
                Customer customer = (Customer) req.getSession().getAttribute("customer");
                String email = customer.getEmail();
                String agent = req.getHeader("user-agent");
                Info i = new Info(sessionId, email, url, agent, new Date());
                infoRepository.save(i);
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }

    }

}
