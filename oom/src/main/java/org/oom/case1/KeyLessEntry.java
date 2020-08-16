package org.oom.case1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/8/16 14:15
 * @notes
 */
public class KeyLessEntry {
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

    public static void main(String[] args) {
        Map m = new HashMap();

        Key key = new Key(1);
        m.put(key,"key1");
        Key key2 = new Key(1);
        m.put(key2,"key1");
        System.out.println(m.size());



//        while (true) {
//            for (int i = 0; i < 10000; i++) {
//                if (!m.containsKey(new Key(i))) {
//                    m.put(new Key(i), "Number:" + i);
//                }
//            }
//            System.out.println(m.keySet().size());
//        }
    }
}
