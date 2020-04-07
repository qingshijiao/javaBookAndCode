package concurrent6;

import java.util.concurrent.locks.LockSupport;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page115 {

    public static void main(String[] args) {

        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");
    }
}
