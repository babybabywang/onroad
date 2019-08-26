package dev.onload.spring.ioc;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-18 23:11
 * @description
 */
public class XmlFactory<T> implements IocFactory<T> {

    @Override
    public T createInstance(T t) {
        return (T) ("xml"+t);
    }
}
