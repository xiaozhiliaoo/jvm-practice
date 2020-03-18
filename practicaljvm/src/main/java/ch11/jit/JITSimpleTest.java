package ch11.jit;

/**
 * -XX:CompileThreshold=1000 -XX:+PrintCompilation
 * 
 * @author Geym
 *
 */
public class JITSimpleTest {

    public static void met(){
        int a=0,b=0;
        b=a+b;
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<500;i++){
            met();
        }
        Thread.sleep(1000);
    }
}
