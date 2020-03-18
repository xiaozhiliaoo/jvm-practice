package ch7.string;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx5m -XX:MaxPermSize=5m 
 * @author Geym
 *
 */
public class StringInternOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
