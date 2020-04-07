package concurrent2;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page65 {

    public static class ReadThead extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) { //(1)
                    System.out.println(num + num); //(2)
                }
                System.out.println("read thread...");
            }
        }
    }

    public static class WriteThead extends Thread {
        @Override
        public void run() {
            num = 2; //(3)
            ready = true; //(4)
            System.out.println("writeThread set over...");
        }
    }

    public static int num = 0;
//    public static boolean ready = false;
    public static volatile boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        ReadThead rt = new ReadThead();
        rt.start();

        WriteThead wt = new WriteThead();
        wt.start();

        Thread.sleep(1000);
        rt.interrupt();
        System.out.println("main exit");
    }
}
