package dev.onload.java.spi.impl;

import dev.onload.java.spi.HelloService;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-17 19:35
 * @description
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("say hello");
    }
}
