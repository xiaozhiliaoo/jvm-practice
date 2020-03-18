package ch4.ref;

import java.lang.ref.WeakReference;

/**
 * 不管当前内存空间足够与否，都会回收它的内存
 * @author geym
 *
 */
public class WeakRef {
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
        WeakReference<User> userWeakRef = new WeakReference<User>(u);
        u=null;
        System.out.println(userWeakRef.get());
        System.gc();
        //不管当前内存空间足够与否，都会回收它的内存
        System.out.println("After GC:");
        System.out.println(userWeakRef.get());
    }
}
