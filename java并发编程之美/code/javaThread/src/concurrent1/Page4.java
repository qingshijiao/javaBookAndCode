package concurrent1;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page4 {

    public static class RunableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {

        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
