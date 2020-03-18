package ch5;

/**
 * 
 * -Xmx64M -Xms64M -XX:+PrintGCDetails
 * @author geym
 *
 */
public class AllocEden {
    public static final int _1K=1024;
    public static void main(String args[]){
        for(int i=0;i<5*_1K;i++){
            byte[] b=new byte[_1K];
        }
        System.gc();
    }
   
}
