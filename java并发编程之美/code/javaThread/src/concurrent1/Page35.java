package concurrent1;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page35 {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
