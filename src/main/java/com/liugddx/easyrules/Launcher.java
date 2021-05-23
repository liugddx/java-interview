package com.liugddx.easyrules;

import org.jeasy.rules.api.Fact;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * <p>@ClassName Launcher</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/23 18:16
 */
public class Launcher {

    public static void main(String[] args) {
        // create facts
        Facts facts = new Facts();

        Fact<Boolean> fact = new Fact("isNow",true);
        facts.add(fact);
        // create rules
        Rules rules = new Rules();
        rules.register(new HelloWorldRule());

        // create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

    }
}
