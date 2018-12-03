package mq.teststart.com.test;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testA {
    @GetMapping("/hello")
    public String hello(){
        if (AlistUtils.strings.size() > 0){
          System.out.println(AlistUtils.strings);
        }
        return "hello";
    }
}
