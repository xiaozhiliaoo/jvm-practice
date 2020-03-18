package ch10;

/**
 * @packgeName: ch10
 * @ClassName: example8
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/10/13-12:54
 * @version: 1.0
 * @since: JDK 1.8
 */
public class example8 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

}
