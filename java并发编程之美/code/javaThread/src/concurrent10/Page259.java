package concurrent10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page259 {

    //创建一个CountDownLatch实例
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

                System.out.println("child threadOne over!");
            }
        });

        //将线程B添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

                System.out.println("child threadTwo over!");
            }
        });

        System.out.println("wait all child thread over!");

        //等待子线程执行完毕，返回
        countDownLatch.await();

        System.out.println("all child thread over");
        executorService.shutdown();
    }
}
