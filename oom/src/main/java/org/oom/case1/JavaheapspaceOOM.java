package org.oom.case1;

/**
 * @author lili
 * @date 2020/8/16 14:07
 * @notes
 */
public class JavaheapspaceOOM {
    static final int MB = 1024 * 1024;
    static final int MBS = 1024 * 512;
    //java.lang.OutOfMemoryError: Java heap space
    //-Xmx12m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+PrintFlagsFinal -XX:+PrintHeapAtGC
    //
    public static void main(String[] args) throws InterruptedException {
        //NewRatio 2  SurvivorRatio 8
        //分配12M堆空间，新生代 4M，Eden 3.2M from 0.4M to 0.4M 老年代 8M
        int[] i = new int[2 * MB];  //2M整数，1个整数4字节，4B，总共8M
    }
}
