package concurrent2;

/**
 * Demo class
 *
 * @author: lmh
 **/
public class Page69 {

    public static class TestForContent {
        static final int LINE_NUM = 1024;
        static final int COLUM_NUM = 1024;

        public void fun() {
            long[][] array = new long[LINE_NUM][COLUM_NUM];
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < LINE_NUM; i++) {
                for (int j = 0; j < COLUM_NUM; j++) {
                    array[i][j] = i * 2 + j;
                }
            }

            long endTime = System.currentTimeMillis();
            long cacheTime = endTime - startTime;
            System.out.println("cache time:" + cacheTime);
        }
    }

    public static class TestForContent2 {
        static final int LINE_NUM = 1024;
        static final int COLUM_NUM = 1024;

        public void fun() {
            long[][] array = new long[LINE_NUM][COLUM_NUM];
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < COLUM_NUM; i++) {
                for (int j = 0; j < LINE_NUM; j++) {
                    array[j][i] = i * 2 + j;
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("no cache time:" + (endTime - startTime));
        }
    }

    public static void main(String[] args) {
        new TestForContent().fun();
//        new TestForContent2().fun();
    }
}
