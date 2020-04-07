package concurrent10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page272 {

    //创建一个Semaphore实例
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {

                    System.out.println(Thread.currentThread() + " over");
                    semaphore.release();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //将线程B添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {

                    System.out.println(Thread.currentThread() + " over");
                    semaphore.release();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //等待子线程执行完毕，返回
        semaphore.acquire(2);
        System.out.println("all child thread over!");

        //关闭线程池
        executorService.shutdown();
    }
}
