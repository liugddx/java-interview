package com.liugddx.easyrule;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;

/**
 * <p>@ClassName HighTemperatureCondition</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:01
 */
public class HighTemperatureCondition implements Condition {
    @Override
    public boolean evaluate(Facts facts) {
        Integer temperature = facts.get("temperature");
        return temperature > 25;
    }

    static HighTemperatureCondition itIsHot() {
        return new HighTemperatureCondition();
    }

}
