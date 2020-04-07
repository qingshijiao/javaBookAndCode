package concurrent11;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page308 {

    //创建threadlocal实例
    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {

        //创建多个线程，并启动
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //使用单例日期实例解析文本
                        System.out.println(safeSdf.get().parse("2017-12-13 15:17:27"));

                    } catch (ParseException e) {
                        e.printStackTrace();
                    } finally {
                        //使用完毕记得清除，避免内存泄漏
                        safeSdf.remove();
                    }
                }
            });

            //启动线程
            thread.start();
        }
    }
}
