package dev.onload.spring.ioc;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-18 23:14
 * @description
 */
public class TestIoc {
    public static void main(String[] args) {
        TestFactory testFactory=new TestFactory();
        System.out.println(testFactory.getInstance("dev.onload.spring.ioc.XmlFactory").createInstance("sss"));
    }
}
