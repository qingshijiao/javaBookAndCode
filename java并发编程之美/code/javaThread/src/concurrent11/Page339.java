package concurrent11;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page339 {

    static class LocalVariable {
        private Long[] a = new Long[1024*1024];
    }

    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 50; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    localVariable.set(new LocalVariable());
                    System.out.println("use local varaible");
//                    localVariable.remove();
                }
            });

            Thread.sleep(1000);
        }
        System.out.println("pool execute over");
    }
}
