
package ch3.heap.newsize;

/**
 * -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * -Xmx20m -Xms20m -Xmn7m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * -Xmx20m -Xms20m -Xmn15m  -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 
 * -Xmx20M -Xms20M -XX:NewRatio=2  -XX:+PrintGCDetails
 * 
 * @author Geym
 */
public class NewSizeDemo {
    public static void main(String[] args) {
       byte[] b=null;
       for(int i=0;i<10;i++)
           b=new byte[1*1024*1024];
    }
}
