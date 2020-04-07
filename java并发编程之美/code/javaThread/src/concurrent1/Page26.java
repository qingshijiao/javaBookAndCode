package concurrent1;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page26 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前进程被中断则退出循环
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        //启动子进程
        thread.start();

        //主进程休眠1s,以使终端前让子进程输出
        Thread.sleep(1000);

        //中断子进程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子进程执行完毕
        thread.join();
        System.out.println("main is over");
    }
}
