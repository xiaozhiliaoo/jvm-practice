package ch5;


/**
 * -XX:+PrintGCDetails  -XX:-ScavengeBeforeFullGC -XX:+UseParallelOldGC
 * 
 * 
 * -XX:+PrintGCDetails -XX:+UseSerialGC
 * @author geym
 *
 */
public class ScavengeBeforeFullGC {
    public static void main(String args[]){
        System.gc();
    }
}
