package dev.onload.jdk.reflect;

import lombok.NoArgsConstructor;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author babywang
 * @version 1.0
 * @date 2019-08-25 00:12
 * @description 反射demo
 * @apiNote https://shimo.im/docs/TqKYQR3xxhWvjKPG/
 */
public class ReflectDemo {

    /**
     * 上前两行实现了类的装载、链接和初始化（newInstance方法实际上也是使用反射调用了<init>方法），
     * 后两行实现了从class对象中获取到method对象然后执行反射调用。下面简单分析一下后两行的原理。
     *
     * @throws Exception
     */
    @Test
    public void testReflectClass() throws Exception {
        Class clazz = Class.forName(TestClass.class.getName());
        Object action = clazz.newInstance();
        Method method = clazz.getMethod("say", null);
        method.invoke(action, null);
    }

    @NoArgsConstructor
    public static class TestClass {

        public void say() {
            System.out.println("say");
        }

    }

}
