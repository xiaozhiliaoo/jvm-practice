package ch6;

public class UseTlab {
    public static void alloc(){
        byte[] b=new byte[2];
        b[0]=1;
        
    }
    public static void main(String args[]){
        while(true){
            alloc();
            Thread.yield();
        }
    }
}
