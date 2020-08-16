package org.oom.case2;

import javassist.CannotCompileException;
import javassist.ClassPool;

/**
 * @author lili
 * @date 2020/8/16 15:11
 * @notes
 */
public class MetaspaceMicroGenerator {

    public static class FullPermSpace extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100_000_000; i++) {
                ClassPool pool = ClassPool.getDefault();
                try {
                    pool.makeClass("org.oom.case1.KeyLessEntry" + i).toClass();
                } catch (CannotCompileException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class FullPermSpace2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100_000_000; i++) {
                ClassPool pool = ClassPool.getDefault();
                try {
                    pool.makeClass("org.oom.case1.LiLi" + i).toClass();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //-XX:MaxPermSize=1M  不生效   -XX:MaxMetaspaceSize=64m
    public static void main(String[] args) throws Exception {
        //-XX:MaxMetaspaceSize=64m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
        FullPermSpace2 fullPermSpace2 = new FullPermSpace2();
        FullPermSpace fullPermSpace = new FullPermSpace();
        fullPermSpace.start();
        fullPermSpace2.start();
    }

}
