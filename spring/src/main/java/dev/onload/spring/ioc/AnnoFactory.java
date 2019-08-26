package dev.onload.spring.ioc;

import org.springframework.context.annotation.Bean;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-18 23:10
 * @description
 */
public class AnnoFactory<T> implements IocFactory<T> {
    @Override
    public T createInstance(T t) {
        return (T) ("anno"+t);
    }
    @Bean
    public IocFactory iocFactory(){
        return new AnnoFactory();
    }
}
