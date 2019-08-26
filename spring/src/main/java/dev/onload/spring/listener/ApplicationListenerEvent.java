package dev.onload.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-14 23:38
 * @description
 */
@Order(LoggingApplicationListener.DEFAULT_ORDER + 1)
@Slf4j
public class ApplicationListenerEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    /**
     * 只执行一次
     */
    private final AtomicBoolean initStart = new AtomicBoolean(false);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        if (initStart.get()) {
            return;
        }
        applicationEnvironmentPreparedEvent.getEnvironment().addActiveProfile("local");
        log.info(buildBannerText());
        initStart.compareAndSet(false, true);
    }

    String buildBannerText() {
        StringBuilder bannerTextBuilder = new StringBuilder();
        bannerTextBuilder
                .append(" :: OnLoad Boot (v").append("1.0.0").append(") : ")
                .append("\n\t")
                .append(" :: Onload (v").append("1.0.0").append(") : ")
                .append("\n\t")
                .append(" :: Discuss group : ")
                .append("\n\t")
                .append("hello");
        return bannerTextBuilder.toString();
    }
}
