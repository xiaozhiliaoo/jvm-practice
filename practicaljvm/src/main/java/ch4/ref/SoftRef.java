package ch4.ref;

import java.lang.ref.SoftReference;

/**
 * -Xmx10m
 * After gc, soft ref is exists
 * after create byte array ,soft ref is gc
 * 
 * @author geym
 *
 */
public class SoftRef {
    public static class User{
        public User(int id,String name){
            this.id=id;
            this.name=name;
        }
        public int id;
        public String name;
        
        @Override
        public String toString(){
            return "[id="+String.valueOf(id)+",name="+name+"]";
        }
    }
    public static void main(String[] args) {
        User u=new User(1,"geym");
        SoftReference<User> userSoftRef = new SoftReference<User>(u);
        u=null;
        
        System.out.println(userSoftRef.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());
        
        byte[] b=new byte[1024*925*7];
        System.gc();
        System.out.println(userSoftRef.get());
    }
}
