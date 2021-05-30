package com.liugddx.asm;

/**
 * <p>@ClassName HelloWorld</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/30 14:07
 */
public class HelloWorld {

    public void sayHello(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
