package com.liugddx.easyrules.controller.rules;

import javax.servlet.http.HttpServletRequest;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * <p>@ClassName SuspiciousRequestRule</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/23 20:50
 */
@Rule
public class SuspiciousRequestRule {

    public static final String SUSPICIOUS = "suspicious";

    @Condition
    public boolean isSuspicious(@Fact("request") HttpServletRequest request) {
        // criteria of suspicious could be based on ip, user-agent, etc.
        // here for simplicity, it is based on the presence of a request parameter 'suspicious'
        return request.getParameter(SUSPICIOUS) != null;
    }

    @Action
    public void setSuspicious(@Fact("request") HttpServletRequest request) {
        request.setAttribute(SUSPICIOUS, true);
    }

}
