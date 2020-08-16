package org.oom.case3;

/**
 * @author lili
 * @date 2020/8/16 16:35
 * @notes
 */
public class MakeThread {
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000000000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
