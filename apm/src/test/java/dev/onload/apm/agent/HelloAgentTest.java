package dev.onload.apm.agent;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-11 14:07
 * @description 测试
 */
public class HelloAgentTest {
    @Ignore
    @Test
    public void echo() {
        System.out.println("hello");
        new HelloWorld().say();

    }


}
