package com.ethen.gateway.filter;

import com.ethen.gateway.enumeration.FilterType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 一个简单的网关过滤器实例，模拟网关的安全验证
 * <p>
 * Note => filterType(): 返回字符串代表过滤器类型，在Zuul中定义了四种不同生命周期的过滤其类型{@link FilterType}
 *         shouldFilter(): 这里可以写逻辑判断，是否需要过滤
 *         filterOrder():过滤器的具体顺序
 *         run():过滤器具体逻辑
 */
@Component
public class SimpleTokenFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTokenFilter.class);

    @Override
    public String filterType() {
        return FilterType.pre.name();
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info("{}>>>{}", request.getMethod(), request.getRequestURI());
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            LOGGER.warn("token is empty!");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                LOGGER.error("sth wrong", e);
                return null;
            }
        }
        LOGGER.info("that is OK.");
        return null;
    }
}
