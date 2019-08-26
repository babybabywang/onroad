package dev.onload.spring;

import dev.onload.spring.listener.ApplicationListenerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-14 23:38
 * @description 启动类
 */
@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private Environment environment;


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationListenerEvent());
        application.run(args);
    }

    @GetMapping
    public String get() {
        return environment.getProperty("spring.application.name");
    }
}
