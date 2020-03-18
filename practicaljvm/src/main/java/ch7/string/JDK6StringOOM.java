package ch7.string;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK6
 * -Xmx5m
 * @author geym
 *
 */
public class JDK6StringOOM {
    public static List<String> strList=new ArrayList<String>();

    public static void main(String args[]){
        for(int i=0;i<10000;i++){
            //模拟读入一个很大的字符串
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<10240;j++){
                sb.append(j);
            }
            //strList.add(new String(sb.toString().substring(0, 1)));
            String str=sb.toString().substring(0, 1);
            strList.add(str);
        }
    }
}

