package concurrent11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page303 {

    //创建map,key为topic,value为设备列表
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        //进入直播间topicl，线程one
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device1");
                list1.add("device2");

                List<String> oldList = map.putIfAbsent("topic1", list1);
                if (null != oldList) {
                    oldList.addAll(list1);
                }

                System.out.println(map.toString());

            }
        });

        //进入直播间topicl，线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device11");
                list1.add("device22");

                List<String> oldList = map.putIfAbsent("topic1", list1);
                if (null != oldList) {
                    oldList.addAll(list1);
                }

                System.out.println(map.toString());

            }
        });

        //进入直播间topic2，线程three
        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device111");
                list1.add("device222");

                List<String> oldList = map.putIfAbsent("topic2", list1);
                if (null != oldList) {
                    oldList.addAll(list1);
                }

                System.out.println(map.toString());

            }
        });

        //启动线程
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
