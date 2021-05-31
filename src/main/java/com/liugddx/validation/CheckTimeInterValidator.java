package com.liugddx.validation;

import cn.hutool.log.Log;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>@ClassName CheckTimeInterValidator</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/31 21:57
 */
@RequiredArgsConstructor
@Slf4j
public class CheckTimeInterValidator implements ConstraintValidator<CheckTimeInterval,Object> {

    private final Comp comp;

    /**
     * FlagValidator注解规定的那些有效值
     */
    private String values;

    @Override
    public void initialize(CheckTimeInterval checkTimeInterval) {
        this.values = checkTimeInterval.values();
    }

    /**
     * 用户输入的值，必须是FlagValidator注解规定的那些值其中之一。
     * 否则，校验不通过。
     * @param value 用户输入的值，如从前端传入的某个值
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // 切割获取值
        String test = comp.getTest();
        log.info(test);
        String[] value_array = values.split(",");
        Boolean isFlag = false;

        for (int i = 0; i < value_array.length; i++){
            // 存在一致就跳出循环
            if (value_array[i] .equals(value)){
                isFlag = true; break;
            }
        }

        return isFlag;
    }
}
