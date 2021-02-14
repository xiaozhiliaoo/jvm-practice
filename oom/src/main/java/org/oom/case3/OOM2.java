package org.oom.case3;

import java.text.DecimalFormat;

/**
 * @author lili
 * @date 2020/8/17 16:43
 * @notes
 */
public class OOM2 {
    public static void main(String[] args) {
        while(true) {
            new DecimalFormat("0.000");
        }
    }
}
