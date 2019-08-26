package dev.onload.apm.agent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-11 13:57
 * @description 使用JavaAgent的Demo
 */
public class HelloAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("装载成功  方法:premain 参数:" + args);
        instrumentation.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
            if ("dev.onload.apm.agent.HelloWorld".equals(className.replaceAll("/", "."))) {
                System.out.println(className);
                ClassPool pool = new ClassPool();
                System.out.println(loader.toString());
                pool.insertClassPath(new LoaderClassPath(loader));
                try {
                    CtClass ctl = pool.get(className);
                    CtMethod method = ctl.getDeclaredMethod("say");
                    method.insertBefore("System.out.println(System.currentTimeMillis());");
                    System.out.println(method);
                    return ctl.toBytecode();
                } catch (NotFoundException | CannotCompileException | IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        });
    }

}
//pre-class