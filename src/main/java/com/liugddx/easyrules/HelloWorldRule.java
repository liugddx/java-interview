package com.liugddx.easyrules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

/**
 * <p>@ClassName HelloWorldRule</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/23 18:15
 */
@Rule(name = "Hello World rule", description = "Always say hello world")
public class HelloWorldRule {

    @Condition
    public boolean when(@Fact("isNow")Boolean isNow) {
        return isNow;
    }

    @Action
    public void then(Facts facts) throws Exception {
        facts.forEach(fact -> System.out.println(fact.getName()));
        System.out.println("hello world");
    }

}
