package concurrent1;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page21 {

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child thread is in awaked");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        thread.start();

        //主线程休眠2s
        Thread.sleep(2000);

        //主线程中断子线程
        thread.interrupt();
    }
}
