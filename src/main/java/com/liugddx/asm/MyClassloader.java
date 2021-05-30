package com.liugddx.asm;

/**
 * <p>@ClassName MyClassloader</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/30 15:26
 */
public class MyClassloader extends ClassLoader{

    public Class<?> defineMyClass( String name, byte[] b, int off, int len)
    {
        return super.defineClass(name,b,off,len);
    }
}
