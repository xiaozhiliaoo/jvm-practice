package ch5;

/**
 * -XX:+PrintGCDetails -XX:-DisableExplicitGC
 * @author geym
 *
 */
public class DisableExplictGC {
    public static void main(String args[]){
        while(true){
            System.gc();
            Thread.yield();
        }
    }
}
