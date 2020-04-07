package concurrent6;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 改造
 *
 * @author: lmh
 **/
public class Page143 {

    //线程不安全的list
    private ArrayList<String> array = new ArrayList<String>();
    //独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    //添加元素
    public void add(String e) {
        lock.lock();
        try {
            array.add(e);
        } finally {
            lock.unlock();
        }
    }

    //删除元素
    public void remove(String e) {
        lock.lock();
        try {
            array.remove(e);
        } finally {
            lock.unlock();
        }
    }

    //获取数据
    public void get(int index) {
        lock.lock();
        try {
            array.get(index);
        } finally {
            lock.unlock();
        }
    }
}
