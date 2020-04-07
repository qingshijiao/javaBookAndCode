package concurrent1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page7 {

    private static Queue<String> queue = new LinkedList<>();
    private static String ele = new String("a");

    public static void main(String[] args) throws InterruptedException {

        //生产线程
        Thread produce = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (queue) {
                        //消费队列满，则等待队列空闲
                        while (queue.size() == Integer.MAX_VALUE) {
                            try {
                                //挂起当前线程，并释放通过同步块获取的queue上的锁，
                                // 让消费者线程可以获取该锁，然后获取队列里面的元素
                                System.out.println("the queue is full");
                                queue.wait();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }

                        //空闲则生成元素，并通知消费者线程
                        System.out.println("produce a string");
                        queue.add(ele);
                        queue.notifyAll();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //消费者线程
        Thread consume = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (queue) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //消费队列为空
                    while (queue.size() == 0) {
                        try {
                            //挂起当前线程，并释放通过同步块获取的queue上的锁，
                            // 让生产者线程可以获取该锁，将生产元素放入队列
                            System.out.println("the queue is already empty");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    //消费元素，并通知唤醒生产者线程
                    System.out.println("consume a string");
                    queue.poll();
                    queue.notifyAll();
                }
            }
        });

        //启动线程
        produce.start();
        consume.start();

        //等待两个线程结束
        produce.join();
        consume.join();

        System.out.println("main over");
    }
}
