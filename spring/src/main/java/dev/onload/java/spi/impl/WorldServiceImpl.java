package dev.onload.java.spi.impl;

import dev.onload.java.spi.HelloService;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-17 19:36
 * @description
 */
public class WorldServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("world");
    }
}
