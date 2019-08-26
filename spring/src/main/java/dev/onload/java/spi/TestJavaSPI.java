package dev.onload.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-17 19:37
 * @description  test java spi
 */
public class TestJavaSPI {
    public static void main(String[] args) {
        ServiceLoader<HelloService> services=ServiceLoader.load(HelloService.class);
        Iterator<HelloService> it = services.iterator();
        while (it!=null&&it.hasNext()){
            HelloService next = it.next();
            next.say();
            System.out.println(next.getClass().getName());
        }
    }
}
