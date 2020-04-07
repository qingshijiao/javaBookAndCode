package concurrent11;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page321 {


    static ThreadPoolExecutor executorOne = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    static ThreadPoolExecutor executorTwo = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    public static void main(String[] args) {

        //接受用户链接模块
        executorOne.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("接受用户链接线程");
                throw new NullPointerException();
            }
        });

        //具体处理用户请求模块
        executorOne.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("具体处理用户请求线程");
            }
        });

        executorOne.shutdown();
        executorTwo.shutdown();
    }
}
