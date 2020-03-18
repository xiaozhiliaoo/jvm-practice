package ch8;

/**
 * Created by lili on 2017/7/16.
 */
public class Test82 {
    public static void main(String[] args){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }


}
