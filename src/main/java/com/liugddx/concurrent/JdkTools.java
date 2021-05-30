package com.liugddx.concurrent;

import org.checkerframework.checker.units.qual.A;

/**
 * <p>@ClassName JdkTools</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/30 16:21
 */
public class JdkTools {

    public static void main(String[] args) {
        Apple a = new Apple();

        new Thread(a,"A").start();
        new Thread(a,"B").start();
        new Thread(a,"C").start();
    }
}
