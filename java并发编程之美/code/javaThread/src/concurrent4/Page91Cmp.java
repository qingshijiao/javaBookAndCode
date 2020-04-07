package concurrent4;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 统计0的个数
 *
 * @author: lmh
 **/
public class Page91Cmp {

    //(1)创建Long型原子计数器
    private static Long num = 0L;
    //(2)创建数据源
    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};
    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String[] args) throws InterruptedException {
        //(3)线程one统计数组arrayOne中0的个数
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i = 0; i < size; i++) {
                    if (arrayOne[i].intValue() == 0){
                        num = num + 1;
                    }
                }
            }
        });

        //(4)线程two统计数组arrayOne中0的个数
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0; i < size; i++) {
                    if (arrayTwo[i].intValue() == 0){
                        num = num + 1;
                    }
                }
            }
        });

        //(5)启动子线程
        threadOne.start();
        threadTwo.start();

        //(6)等待线程执行完毕
        threadOne.join();
        threadTwo.join();

        System.out.println("count 0:" + num);
    }

}
