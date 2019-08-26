package dev.onload.spring.ioc;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-18 23:12
 * @description
 */
public class TestFactory<T> {
    public IocFactory<T> getInstance(String className){
        IocFactory<T> iocFactory=null;
        try {
            iocFactory = (IocFactory<T>) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return iocFactory;
    }
}
