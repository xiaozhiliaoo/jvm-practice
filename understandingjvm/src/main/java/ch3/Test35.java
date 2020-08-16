package ch3;

/**
 * Created by lili on 2017/7/16.
 */
public class Test35 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
    }

    public static void main(String[] args) {
        //老年代 10M  年轻代 10M 8M eden 1M from 1M to
        //allocation1，allocation2，allocation3在eden区分配，但是allocation4在old区分配，
        testAllocation();
    }


}
