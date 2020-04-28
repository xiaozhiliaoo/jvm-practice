package sxt;

import java.util.Vector;

/**
 * Created by lili on 2017/5/17.
 */
public class OOMException {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1024*1024]); //1M
        }
    }
}
