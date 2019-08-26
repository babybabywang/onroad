package dev.onload.spring.ioc;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-18 23:09
 * @description IOC工厂
 */
public interface IocFactory<T> {
    T createInstance(T t);
}
