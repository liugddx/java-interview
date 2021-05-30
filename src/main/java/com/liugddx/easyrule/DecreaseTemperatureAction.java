package com.liugddx.easyrule;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

/**
 * <p>@ClassName DecreaseTemperatureAction</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:02
 */
public class DecreaseTemperatureAction implements Action {

    @Override
    public void execute(Facts facts) throws Exception {
        System.out.println("It is hot! cooling air..");
        Integer temperature = facts.get("temperature");
        facts.put("temperature", temperature - 1);
    }

    static DecreaseTemperatureAction decreaseTemperature() {
        return new DecreaseTemperatureAction();
    }
}
