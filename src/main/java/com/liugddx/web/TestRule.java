package com.liugddx.web;

import com.liugddx.utils.WebUtil;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.springframework.stereotype.Component;

/**
 * <p>@ClassName TestRule</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:36
 */
@Component
@Rule
@Slf4j
public class TestRule {

    static final String TEST = "test";

    @Condition
    public boolean isSuspicious(@Fact("request") HttpServletRequest request) {

        String requestContent = WebUtil.getRequestContent(request);

        log.info(requestContent);

        while (request.getParameterNames().hasMoreElements()){
            String s = request.getParameterNames().nextElement();
            log.info(String.format("the param is {}", s));
        }
        // criteria of suspicious could be based on ip, user-agent, etc.
        // here for simplicity, it is based on the presence of a request parameter 'suspicious'
        return request.getParameter(TEST) != null;
    }

    @Action
    public void setSuspicious(@Fact("request") HttpServletRequest request) {
        request.setAttribute(TEST, true);
    }
}
