package concurrent11;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page324 {


    static ThreadPoolExecutor executorOne = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(), new NamedThreadFactory("ASYN-ACCEPT-POOL"));
    static ThreadPoolExecutor executorTwo = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(), new NamedThreadFactory("ASYN-PROCESS-POOL"));

    //命名线程工厂
    static class NamedThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NamedThreadFactory(String name) {

            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup():Thread.currentThread().getThreadGroup();
            if (null == name || name.isEmpty()) {
                name = "pool";
            }

            namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);

            }
            return t;
        }
    }

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
