package com.liugddx.agent;

import java.lang.instrument.Instrumentation;

/**
 * <p>@ClassName Agent</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/30 17:54
 */
public class Agent {

    public static void premain(String args, Instrumentation instrumentation){
        ClassLogger transformer = new ClassLogger();
        instrumentation.addTransformer(transformer);
    }

}
