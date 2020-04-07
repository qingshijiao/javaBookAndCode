package concurrent1;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page36 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //设置为守护线程
        thread.setDaemon(true);

        //启动子线程
        thread.start();

        System.out.println("main thread is over");
    }
}
