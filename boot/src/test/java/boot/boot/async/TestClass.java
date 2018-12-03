package boot.boot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class TestClass {

    public static Random random =new Random();

    @Async
    public Future<String> one1() throws InterruptedException {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");

        return new AsyncResult("$$$$$$$$$$");
    }

    @Async
    public Future<User> two1() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        User user = new User();
        user.setAge("18");
        user.setName("xiao");
        return new AsyncResult<>(user);
    }

    @Async
    public void three1() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
