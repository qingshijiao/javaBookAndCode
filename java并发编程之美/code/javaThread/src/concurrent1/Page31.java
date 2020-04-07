package concurrent1;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page31 {

    //创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "get ResourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }
            }
        });

//        //创建线程B
//        Thread threadB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resourceB) {
//                    System.out.println(Thread.currentThread() + "get ResourceB");
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(Thread.currentThread() + "waiting get resourceA");
//                    synchronized (resourceA) {
//                        System.out.println(Thread.currentThread() + "get resourceA");
//                    }
//                }
//            }
//        });

        //启动线程

        //创建线程B --- 修改后
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "get ResourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
