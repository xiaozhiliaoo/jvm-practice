package ch5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geym
 *
 */
public class ComputeTenuringThreshold {
    public static final int _1M=1024*1024;
    public static final int _1K=1024;
    public static void main(String args[]){
        Map<Integer,byte[]> map=new HashMap<Integer,byte[]>();

        for(int i=0;i<5*_1K;i++){
            byte[] b=new byte[_1K];
            map.put(i, b);
        }

        //触发新生代GC
        for(int k=0;k<17;k++){
            for(int i=0;i<270;i++){
                byte[] g=new byte[_1M];
            }
        }
    }
}
