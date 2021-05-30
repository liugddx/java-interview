package com.liugddx.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * <p>@ClassName SpringFactoryBean</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/23 21:19
 */
public class SpringFactoryBean implements FactoryBean<BeanDemo> {

    private Class<?> type;


    @Override
    public BeanDemo getObject() throws Exception {

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }
}
