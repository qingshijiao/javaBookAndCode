package concurrent5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page111 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("hello");
        arrayList.add("alibaba");

        Iterator<String> itr = arrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
