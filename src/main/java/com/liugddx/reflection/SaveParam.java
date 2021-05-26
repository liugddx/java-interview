package com.liugddx.reflection;

import com.liugddx.utils.ThreadLocalUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>@ClassName SaveParam</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/24 15:39
 */
public class SaveParam {

    public void saveDocInfoToThreadLocal(Object... objs){

        Map<String,Object> docInfoMap = new HashMap<>(8);

        Method saveDocInfoToThreadLocal = Arrays.stream(SaveParam.class.getMethods())
                .filter(method -> "saveDocInfoToThreadLocal".equals(method.getName())).collect(
                        Collectors.toList()).get(0);
        Parameter[] parameters = saveDocInfoToThreadLocal.getParameters();
        for (int index =0;index<parameters.length;index++){
            docInfoMap.put(parameters[index].getName(),objs[index]);
        }

        ThreadLocalUtil.set("test",docInfoMap);

    }

    public static void main(String[] args) {
        int b = 1;
        String x = "w";
        SaveParam saveParam = new SaveParam();
        saveParam.saveDocInfoToThreadLocal(b,x);
    }

}
