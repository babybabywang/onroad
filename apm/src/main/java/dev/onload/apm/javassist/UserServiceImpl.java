package dev.onload.apm.javassist;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-11 18:20
 * @description
 */
public class UserServiceImpl {
    public void sayHello() {
        System.out.println("hello");
    }

    public void addUser(String name, String sex) {
        System.out.println(name + sex);
        addUser(name,sex);
    }
    public void addUser2(String name, String sex) {
        System.out.println(name + sex);
    }

}
