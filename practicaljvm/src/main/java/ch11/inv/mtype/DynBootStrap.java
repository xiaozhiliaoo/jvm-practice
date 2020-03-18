package ch11.inv.mtype;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class DynBootStrap {
    public static CallSite bootstrap(Lookup lookup, String name, MethodType type,Object handle) throws Exception {  
        MethodHandle mh0 = lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class,int.class)).bindTo("hello");

        System.out.println("bootstrap called,name="+name);
        System.out.println(handle.toString());
//        mh0
        return new ConstantCallSite(mh0);  
    }  
}
