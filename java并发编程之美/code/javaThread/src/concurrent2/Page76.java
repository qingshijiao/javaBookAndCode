package concurrent2;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page76 {

    public synchronized void helloA() {
        System.out.println("hello");
    }

    public synchronized void helloB() {
        System.out.println("hello B");
        helloA();
    }

    public static void main(String[] args) {
        new Page76().helloB();
    }
}
