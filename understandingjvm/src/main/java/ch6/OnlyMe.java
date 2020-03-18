package ch6;

/**
 * @packgeName: ch6
 * @ClassName: OnlyMe
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/10/14-16:58
 * @version: 1.0
 * @since: JDK 1.8
 */
class Foo{}

public class OnlyMe {
    void onlyme(Foo f){
        synchronized (f){
            System.out.println("do something ");
        }
    }

    synchronized void onlyme2(){
        System.out.println("do something else");
    }
}
