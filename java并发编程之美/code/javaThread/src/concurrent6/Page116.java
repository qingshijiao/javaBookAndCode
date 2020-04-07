package concurrent6;

import java.util.concurrent.locks.LockSupport;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page116 {

    public static void main(String[] args) {

        System.out.println("begin park!");

        //使当前线程获取到许可证
        LockSupport.unpark(Thread.currentThread());

        //再次调用park方法
        LockSupport.park();

        System.out.println("end park!");
    }
}
