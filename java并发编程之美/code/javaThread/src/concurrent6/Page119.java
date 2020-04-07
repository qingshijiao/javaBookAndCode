package concurrent6;

import java.util.concurrent.locks.LockSupport;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page119 {

    public void testPark() {
        LockSupport.park();
    }

    public static void main(String[] args) {

        Page119 page119 = new Page119();
        page119.testPark();
    }

}
