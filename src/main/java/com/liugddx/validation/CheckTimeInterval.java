package com.liugddx.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = CheckTimeInterValidator.class)
public @interface CheckTimeInterval {
    // flag的有效值，多个使用,隔开
    String values();

    // flag无效时的提示内容
    String message() default "flag必须是预定义的那几个值，不能随便写";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
