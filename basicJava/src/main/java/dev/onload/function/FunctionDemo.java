package dev.onload.function;

import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-25 23:25
 * @description Function函数化编程demo
 */
public class FunctionDemo {
    /**
     * Function是一个接口，那么Function.identity()是什么意思呢？解释如下：
     * Java 8允许在接口中加入具体方法。接口中的具体方法有两种，default方法和static方法，identity()就是Function接口的一个静态方法。
     * Function.identity()返回一个输出跟输入一样的Lambda表达式对象，等价于形如t -> t形式的Lambda表达式。
     */
    @Test
    public void testFunction() {
        // 将Stream转换成容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }
}
