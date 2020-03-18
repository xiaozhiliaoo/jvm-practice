package ch7.string;

import java.util.ArrayList;

/**
 * JDK6
 * -XX:MaxPermSize=5m
 * ava.lang.OutOfMemoryError: PermGen space
 *
 * JDK7
 * -XX:MaxPermSize=5m -XX:+PrintGC
 * 分配在堆
 *
 * @author geym
 *
 */
public class StringIntern {

    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<String>();
        for(int i=0;i<1024*1024*7;i++){
            al.add(String.valueOf(i).intern());
        }

    }

}
