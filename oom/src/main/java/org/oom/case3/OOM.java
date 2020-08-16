package org.oom.case3;

import java.util.ArrayList;

/**
 * @author lili
 * @date 2020/8/16 16:57
 * @notes
 */
public class OOM {
    public static void main(String[] args) {
        // java.lang.OutOfMemoryError: Java heap space
        ArrayList<int[]> objects = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            objects.add(new int[100_000_000]);
        }
    }
}
