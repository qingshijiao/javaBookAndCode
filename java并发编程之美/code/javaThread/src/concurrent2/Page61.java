package concurrent2;

import sun.misc.Unsafe;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page61 {

    //获取Unsafe的实例(2.2.1)
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量state在类Page61中的偏移量(2.2.2)
    static final long stateOffset;

    //变量(2.2.3)
    private volatile long state = 0;

    static {
        try {
            //获取state变量在类Page61中的偏移量(2.2.4)
            stateOffset = unsafe.objectFieldOffset(Page61.class.getDeclaredField("state"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {

        //创建实例，并且设置state值为1(2.2.5)
        Page61 test = new Page61();
        //(2.2.6)
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
