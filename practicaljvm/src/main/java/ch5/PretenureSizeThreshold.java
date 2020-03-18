package ch5;

import java.util.HashMap;
import java.util.Map;

/**
 * 超过给定大小的对象直接晋升
 * -Xmx32m -Xms32m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000
 * 必须禁止TLAB，否则小对象依然会在eden区
 * -Xmx32m -Xms32m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB
 * @author geym
 *
 */
public class PretenureSizeThreshold {
    public static final int _1K=1024;
    public static void main(String args[]){
        Map<Integer,byte[]> map=new HashMap<Integer,byte[]>();
        for(int i=0;i<5*_1K;i++){
            byte[] b=new byte[_1K];
            map.put(i, b);
        }
    }
}
