package concurrent7;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page214 {

    static class Task implements Comparable<Task> {

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        private int priority = 0;

        private String taskName;


        @Override
        public int compareTo(Task o) {
            if (this.priority >= o.getPriority()) {
                return 1;
            } else {
                return -1;
            }
        }

        public void doSomeThing() {
            System.out.println(taskName + ":" + priority);
        }
    }

    public static void main(String[] args) {


        //创建任务，并添加到队列
        PriorityBlockingQueue<Task> priorityQueue = new PriorityBlockingQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskName" + i);
            priorityQueue.offer(task);
        }

        //取出任务执行
        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            if (null != task) {
                task.doSomeThing();
            }
        }
    }
}
