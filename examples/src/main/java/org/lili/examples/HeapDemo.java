package org.lili.examples;

/**
 * Created by lili on 2017/5/17.
 */
public class HeapDemo {

    private static final int size = 1 * 1024 * 1024;

    /**
     * vm config:
     * -Xmx20m -Xms20m -Xmn1m -XX:+PrintGCDetails -XX:+UseSerialGC
     *
     * -Xmx20m -Xms20m -Xmn15m -XX:+PrintGCDetails -XX:+UseSerialGC
     *
     * -Xmx20m -Xms20m -Xmn7m -XX:+PrintGCDetails -XX:+UseSerialGC
     *
     * -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
     *
     * -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:NewRatio=1 -XX:+PrintGCDetails -XX:+UseSerialGC
     *
     *
     *
     */


    public static void main(String[] args) {


        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[size];
        }
    }
}
