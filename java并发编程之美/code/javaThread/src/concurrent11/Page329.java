package concurrent11;

import java.util.concurrent.*;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page329 {

    //线程池单个线程，线程池队列元素个数为1
//    private final static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES,
//            new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardPolicy());
//    private final static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES,
//            new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
    private final static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //添加任务one
        Future futureOne = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start runable one");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //添加任务two
        Future futureTwo = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start runable two");
            }
        });

        //添加任务three
        Future futureThree = null;
        try {
            futureThree = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start runable three");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        //等待任务one执行完毕
        System.out.println("task one " + futureOne.get());
        //等待任务two执行完毕
        System.out.println("task two " + futureTwo.get());
        //等待任务three执行完毕
        try {
            System.out.println("task three " + (futureThree==null?null:futureThree.get()));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        //关闭线程池，阻塞直到所有任务执行完毕
        executorService.shutdown();
    }
}
