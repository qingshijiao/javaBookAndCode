package concurrent10;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page266 {

    //创建一个CyclicBarrier实例
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
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
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //关闭线程池
        executorService.shutdown();
    }
}
