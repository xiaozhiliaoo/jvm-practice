package ch6;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @packgeName: ch6
 * @ClassName: GetSignature
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/10/14-16:45
 * @version: 1.0
 * @since: JDK 1.8
 */
public class GetSignature<T> {
    public static void main(String[] args) throws ClassNotFoundException {

        Class c = Class.forName("java.lang.String");
        System.out.println(c);
        Type[] t = c.getGenericInterfaces();
        System.out.println(t);
        for (Type type : t) {
            if (type instanceof ParameterizedType) {
//          System.out.println("in if");
                Type[] p = ((ParameterizedType) type).getActualTypeArguments();
          System.out.println(Arrays.toString(p));
//            this.clazz = (Class<T>) p[0];
            }
        }

    }

}
