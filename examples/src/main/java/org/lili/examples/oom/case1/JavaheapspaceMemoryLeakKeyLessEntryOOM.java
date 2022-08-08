package org.lili.examples.oom.case1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/8/16 14:15
 * @notes
 */
public class JavaheapspaceMemoryLeakKeyLessEntryOOM {
    public static class Key {
        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Map m = new HashMap();

        Key key = new Key(1);
        m.put(key,"key1");
        Key key2 = new Key(1);
        m.put(key2,"key1");
        System.out.println(m.size());


        //java.lang.OutOfMemoryError: GC overhead limit exceeded
        while (true) {
            for (int i = 0; i < 1000000000; i++) {
                if (!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
            System.out.println(m.keySet().size());
        }
    }
}
