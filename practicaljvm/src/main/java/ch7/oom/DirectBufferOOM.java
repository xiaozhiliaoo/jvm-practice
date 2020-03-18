package ch7.oom;

import java.nio.ByteBuffer;
/**
 * -Xmx512m -XX:+PrintGCDetails  ok  
 * -Xmx1g -XX:+PrintGCDetails    OOM 强制GC可以
 * DirectBuffer到达-XX:MaxDirectMemorySize之前，
 * java不会由DirectBuffer来触发GC，但是在GC时会回收DirectBuffer
 * @author Geym
 *
 */
public class DirectBufferOOM {
    public static void main(String args[]){
        for(int i=0;i<1024;i++){
            ByteBuffer.allocateDirect(1024*1024);
            System.out.println(i);
//            System.gc();
        }
    }
}
