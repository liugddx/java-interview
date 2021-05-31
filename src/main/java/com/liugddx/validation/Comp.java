package com.liugddx.validation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>@ClassName Comp</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/31 22:14
 */
@Component
@Data
public class Comp {

    @Value("${test:liugd}")
    private String test;

}
