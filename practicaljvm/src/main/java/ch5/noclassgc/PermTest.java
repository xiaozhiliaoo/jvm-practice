package ch5.noclassgc;

import java.util.HashMap;

/**
 * noclassgc 不会回收perm
 *-XX:+PrintGCDetails -XX:PermSize=5M -XX:MaxPermSize=5m  -verbose:class -Xnoclassgc
 *
 * Perm默认不用CMS，加了CMSClassUnloadingEnabled启用CMS回收Perm
 * -XX:+PrintGCDetails -XX:PermSize=5M -XX:MaxPermSize=5m  -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled
 * @author Geym
 *
 */
public class PermTest {

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            CglibBean bean = new CglibBean("geym.zbase.ch5.perm"+i,new HashMap());
        }
    }

}

