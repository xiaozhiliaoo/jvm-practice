package ch10;

import java.util.Arrays;
import java.util.List;

/**
 * @packgeName: ch10
 * @ClassName: example6
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/10/13-12:46
 * @version: 1.0
 * @since: JDK 1.8
 */
public class example6 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 如果在JDK 1.7中，还有另外一颗语法糖 ，
        // 能让上面这句代码进一步简写成List<Integer> list = [1, 2, 3, 4];
        int sum = 0;
        for(int i:list){
            sum += i;
        }
        System.out.println(sum);
    }
}
