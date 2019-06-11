package com.codewolf.shop.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    private Boolean forceEncoding = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        forceEncoding = Boolean.parseBoolean(filterConfig.getInitParameter
                ("forceEncoding"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (encoding != null && forceEncoding) {
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
