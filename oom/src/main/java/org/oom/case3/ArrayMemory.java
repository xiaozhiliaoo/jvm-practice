package org.oom.case3;

/**
 * @author lili
 * @date 2020/8/16 16:50
 * @notes
 */
public class ArrayMemory {
    public static void main(String[] args) {
        //Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        for (int i = 0; i < 4; i++) {
            int[] arr = new int[Integer.MAX_VALUE - 1];
        }
    }
}
