package ch7;

/**
 * Created by lili on 2017/7/16.
 */
public class Test76 {
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }


}
