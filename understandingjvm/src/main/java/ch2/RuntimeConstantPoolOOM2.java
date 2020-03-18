package ch2;

/**
 * Created by lili on 2017/7/16.
 */
public class RuntimeConstantPoolOOM2 {

    public static void main(String[] args) {

            String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
            System.out.println(str1.intern() == str1);

            String str2 = new StringBuilder("ja").append("va").toString();
            System.out.println(str2.intern() == str2);
    	}
}


