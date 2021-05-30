package com.liugddx.web;

import java.util.Arrays;
import java.util.Map;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@ClassName EasyRuleConfig</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:12
 */
@Configuration
public class EasyRuleConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public RulesEngine rulesEngine(){

        return new DefaultRulesEngine();
    }

    @Bean
    public Rules rules(){
        Rules rulesRegister = new Rules();
        Map<String, Object> rules = applicationContext
                .getBeansWithAnnotation(Rule.class);
        Arrays.asList(rules.values().toArray()).forEach(rulesRegister::register);
        return rulesRegister;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
