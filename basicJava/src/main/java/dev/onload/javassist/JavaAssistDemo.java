package dev.onload.javassist;

import javassist.*;
import org.junit.Test;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-24 21:11
 * @description JavaAssist入门
 */
public class JavaAssistDemo {
    /**
     * 测试生成类
     *
     * @throws Exception
     */
    @Test
    public void inputOutputForJavassist() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //从classpath中查询该类
        CtClass ctClass = pool.get("dev.onload.javassist.Test");
        //设置.Test的父类
        ctClass.setSuperclass(pool.get("dev.onload.javassist.SupTest"));
        //输出.Rectangle.class文件到该目录中
        ctClass.writeFile("dev.onload.javassist.generate");
        //输出成二进制格式
        byte[] b = ctClass.toBytecode();
        //输出并加载class 类，默认加载到当前线程的ClassLoader中，也可以选择输出的ClassLoader。
        Class clazz = ctClass.toClass();
        System.out.println(clazz);
    }

    /**
     * 新增class
     *
     * @throws Exception
     */
    @Test
    public void addClass() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("Add");
        cc.addMethod(new CtMethod(CtClass.intType, "hello", new CtClass[]{CtClass.intType}, cc));
        cc.addField(new CtField(CtClass.intType, "name", cc));
        //输出.Rectangle.class文件到该目录中
        cc.writeFile("dev.onload.javassist.generate");
        //输出成二进制格式
        byte[] b = cc.toBytecode();
        //输出并加载class 类，默认加载到当前线程的ClassLoader中，也可以选择输出的ClassLoader。
        Class clazz = cc.toClass();
        System.out.println(clazz);
    }

    /**
     * Class 搜索路径
     * 从上面可以看出Class 的载入是依靠ClassPool，而ClassPool.getDefault() 方法的搜索Classpath 只是搜索JVM的同路径下的class。
     * 当一个程序运行在JBoss或者Tomcat下，ClassPool Object 可能找到用户的classes。Javassist 提供了四种动态加载classpath的方法
     *
     * @throws Exception
     */
    @Test
    public void searchClass() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //从file里加载classpath
        pool.insertClassPath("dev.onload.javassist.generate");
        //从URL中加载
        ClassPath cp = new URLClassPath("www.javassist.org", 80, "/java/", "org.javassist.");
        pool.insertClassPath(cp);
        //从byte[]中加载
        byte[]a=new byte[2048];
        
    }
}
