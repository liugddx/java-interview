package com.liugddx.javassist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javassist.*;

/**
 * <p>@ClassName CreatePerson</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/22 22:12
 */
public class CreatePerson {

    public static void createPerson()
            throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();

        //1、创建一个空类
        CtClass cc = pool.makeClass("com.liugddx.javassist.Person");

        //2、创建一个字段
        CtField param = new CtField(pool.get("java.lang.String"), "name", cc);

        //3、访问级别
        param.setModifiers(Modifier.PRIVATE);

        cc.addField(param, CtField.Initializer.constant("xiaoming"));


        // 3. 生成 getter、setter 方法
        cc.addMethod(CtNewMethod.setter("setName", param));
        cc.addMethod(CtNewMethod.getter("getName", param));

        // 4. 添加无参的构造函数
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
        cons.setBody("{name = \"xiaohong\";}");
        cc.addConstructor(cons);

        // 5. 添加有参的构造函数
        cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, cc);
        // $0=this / $1,$2,$3... 代表方法参数
        cons.setBody("{$0.name = $1;}");
        cc.addConstructor(cons);

        // 6. 创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(name);}");
        cc.addMethod(ctMethod);

        Object person = cc.toClass().newInstance();
        Method setName = person.getClass().getMethod("setName", String.class);

        setName.invoke(person, "cunhua");

        Method execute = person.getClass().getMethod("printName");

        execute.invoke(person);


    }

    public static void main(String[] args)
            throws NotFoundException, CannotCompileException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        createPerson();
    }


}
