package ch5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *-Xmx10M -Xms10M -Xmn1m -XX:+PrintGCDetails
 *  新生代太小，大对象直接晋升
 *
 *
 * @author geym
 *
 */
public class BigObject {
    public static final int _100K=1024*100;
    public static void main(String args[]){
        Map<Integer,byte[]> map=new HashMap<Integer,byte[]>();
        for(int i=0;i<5;i++){
            byte[] b=new byte[_100K];
            map.put(i, b);
        }
//        System.gc();
    }
}
