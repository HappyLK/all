package mq.teststart.com.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStart implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        AlistUtils.getList();
    }
}
