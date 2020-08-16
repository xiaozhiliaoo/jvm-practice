package org.oom.case2;

import java.util.Map;
import java.util.Random;

/**
 * @author lili
 * @date 2020/8/16 14:48
 * @notes
 */
public class GCoverheadlimitWrapper {
    //-Xmx20m -XX:+UseParallelGC -XX:+PrintGCDetails
    public static void main(String[] args) {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}
