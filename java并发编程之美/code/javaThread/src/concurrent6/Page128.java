package concurrent6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page128 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
        try {
            System.out.println("begin wait");
            condition.await();
            System.out.println("end wait");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        lock.lock();
        try {
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
