package concurrent11;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page319 {

    public static void main(String[] args) {

        //订单模块
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保护订单的线程");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new NullPointerException();
            }
        });

        //发货模块
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存收获地址的线程");
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
