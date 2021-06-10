package com.liugddx.optional;

import java.util.Optional;

/**
 * <p>@ClassName OptionalTest</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/6/2 15:41
 */
public class OptionalTest {

    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(null).isPresent());
    }
}
