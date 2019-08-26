package dev.onload.apm.agent;

import dev.onload.apm.javassist.UserServiceImpl;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-11 18:21
 * @description
 */
public class JavassistTest {
    @Test
    public void updateMethod() throws Exception {

        ClassPool pool = new ClassPool();
        pool.appendSystemPath();
        CtClass ctl = pool.get("dev.onload.apm.javassist.UserServiceImpl");
        //向UserServiceImpl类中加入abc成员变量
        CtField ctField = new CtField(pool.get(String.class.getName()), "abc", ctl);
        ctl.addField(ctField);
        byte[] bytes = ctl.toBytecode();
        File file = new File(System.getProperty("user.dir") + "/target/UserServiceImpl.class");
        file.createNewFile();
        Files.write(file.toPath(), bytes);

    }

    @Test
    public void specialSymbol() throws Exception {
        ClassPool pool = new ClassPool();
        pool.appendSystemPath();
        CtClass ctl = pool.get("dev.onload.apm.javassist.UserServiceImpl");
        CtMethod method = ctl.getDeclaredMethod("addUser");
        method.insertBefore("System.out.println($0);");
        method.insertBefore("System.out.println($1);");
        method.insertBefore("System.out.println($2);");
        method.insertBefore("addUser2($$);");
        ctl.toClass();
        new UserServiceImpl().addUser("hsm", "meng");

    }
}
