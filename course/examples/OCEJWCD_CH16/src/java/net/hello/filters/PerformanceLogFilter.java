package net.hello.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PerformanceLogFilter implements Filter {
    
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        long start = System.currentTimeMillis();
        
        chain.doFilter(request, response);
        
        long end = System.currentTimeMillis();
        
        ServletContext context = filterConfig.getServletContext();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        StringBuilder message = new StringBuilder();
        message.append("-------------------");
        message.append(httpRequest.getRequestURI());
        message.append(" : ");
        message.append(end - start);
        message.append(" ms");
        context.log(message.toString());
    }

    @Override
    public void destroy() {
        
    }
    
}
