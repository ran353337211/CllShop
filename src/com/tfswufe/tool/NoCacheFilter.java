package com.tfswufe.tool;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "NoCacheFilter")
public class NoCacheFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse hsr = (HttpServletResponse)resp;
        hsr.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        hsr.setHeader("Pragma","no-cache");
        hsr.setDateHeader("Expires",0);
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
