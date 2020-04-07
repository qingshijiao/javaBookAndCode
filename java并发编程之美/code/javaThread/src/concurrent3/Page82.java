package concurrent3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page82 {

    public static void main(String[] args) {

        //(1)创建一个随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();
        //(2)输出10个在0~5（包含0，不包含5）之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
