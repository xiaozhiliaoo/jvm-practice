package ch10;


import java.util.*;

/**
 * @packgeName: ch10
 * @ClassName: example2
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/10/13-12:42
 * @version: 1.0
 * @since: JDK 1.8
 */
public class example2 {
    //注意查看target中的字节码 会自动加入构造方法
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }

}
