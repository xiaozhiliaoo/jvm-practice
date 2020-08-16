package org.oom.case1;

/**
 * @author lili
 * @date 2020/8/16 14:07
 * @notes
 */
public class OOM {
    static final int MB = 1024 * 1024;
    //-Xmx12m
    public static void main(String[] args) {
        int[] i = new int[2 * MB];
    }
}
