package com.microcompany.accountsservice.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebFilter(urlPatterns = "/accounts")
@Component
@Profile("prod")
public class IPFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(IPFilter.class);
    private static final List<String> allowedIPs = List.of("0:0:0:0:0:0:0:1","127.0.0.1");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String remoteIp = request.getRemoteAddr();
        logger.info("Enter filter....." + remoteIp);
        if (allowedIPs.contains(remoteIp)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendError(403);
            return;
        }
    }
}
