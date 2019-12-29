package com.ethen.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 统计接口耗时
 * <p>
 * todo 在过滤器中，通过uri获取执行的目标类、方法
 */
@Slf4j(topic = "ApiAccessLog")
@Component
public class ApiAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("ApiAccessFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            StopWatch stopWatch = new StopWatch();
            String reqUri = req.getRequestURI();
            String reqMethod = req.getMethod();
            stopWatch.start(String.format("%s#%s", reqUri, reqMethod));
            filterChain.doFilter(request, response);
            stopWatch.stop();
            log.debug(stopWatch.prettyPrint());
        }
    }

    @Override
    public void destroy() {
        log.debug("ApiAccessFilter destroyed");
    }
}
