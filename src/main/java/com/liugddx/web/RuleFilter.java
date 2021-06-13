package com.liugddx.web;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.stereotype.Component;

/**
 * <p>@ClassName RuleFilter</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:30
 */
//@Component
@AllArgsConstructor
public class RuleFilter implements Filter {

    private final RulesEngine rulesEngine;
    private final Rules rules;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;

        Facts facts = new Facts();

        if (servletRequest instanceof HttpServletRequest) {
            requestWrapper = new MyHttpServletRequestWrapper((HttpServletRequest) servletRequest);
        }
        //获取请求中的流，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if (requestWrapper == null) {
            facts.put("request", servletRequest);
            rulesEngine.fire(rules, facts);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            facts.put("request", requestWrapper);
            rulesEngine.fire(rules, facts);
            filterChain.doFilter(requestWrapper, servletResponse);
        }

    }
}
