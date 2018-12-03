package mq.teststart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TeststartApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeststartApplication.class, args);
    }
}
