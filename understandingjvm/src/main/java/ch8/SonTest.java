package ch8;

/**
 * @packgeName: ch8
 * @ClassName: SonTest
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/10/14-12:31
 * @version: 1.0
 * @since: JDK 1.8
 */
class GrandFather{
    void thinking(){
        System.out.println("I am a grandfather");
    }
}

class Father extends GrandFather{
    void thinking(){
        System.out.println("I am a father");
    }
}

class Son extends Father{
    void thinking(){
        GrandFather father = new GrandFather();
        father.thinking();
    }
}


public class SonTest {
    public static void main(String[] args) {
        Son s = new Son();
        s.thinking();
    }
}
