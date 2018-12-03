package boot.boot.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Async {
    public static Random random =new Random();

    @Resource
    private TestClass testClass;

    @Test
    public void test01() throws InterruptedException {
        one();
        two();
        three();
    }

    @Test
    public void test02() throws InterruptedException, ExecutionException {
        System.out.println("1");
        Future<String> stringFuture = testClass.one1();

        System.out.println("2");
        Future<User> userFuture = testClass.two1();
        System.out.println("3");
        testClass.three1();
        System.out.println("4");

//        while (stringFuture.isDone() && userFuture.isDone()) {
//            System.out.println(stringFuture.get());
//            System.out.println(userFuture.get());
//        }

        while (true) {
            if (stringFuture.isDone() && userFuture.isDone()) {
                System.out.println(stringFuture.get());
                System.out.println(userFuture.get());
            }
        }
    }


    public void one() throws InterruptedException {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    public void two() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    public void three() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
