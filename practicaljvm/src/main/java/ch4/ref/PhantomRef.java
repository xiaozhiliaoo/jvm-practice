package ch4.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

;

/**
 * 不管当前内存空间足够与否，都会回收它的内存
 * @author geym
 *
 */
public class PhantomRef {

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

    static ReferenceQueue<User> phantomQueue=null;
    public static class CheckRefQueue extends Thread{

        @Override
        public void run(){
            while(true){
                if(phantomQueue!=null){
                    UserPhantomReference obj=null;
                    try {
                        obj = (UserPhantomReference) phantomQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(obj!=null)
                        System.out.println("user id "+obj.uid+" is delete");

                }
            }
        }
    }

    public static class UserPhantomReference extends PhantomReference<User>{
        int uid;
        public UserPhantomReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid=referent.id;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        User u=new User(1,"geym");
        phantomQueue = new ReferenceQueue<User>();
        UserPhantomReference userPhantomRef = new UserPhantomReference(u,phantomQueue);
        u=null;
        //always  null
        System.out.println(userPhantomRef.get());
        System.gc();
        //不管当前内存空间足够与否，都会回收它的内存
        System.out.println("After GC:");
        System.out.println(userPhantomRef.get());

        Thread.sleep(1000);
    }

}
