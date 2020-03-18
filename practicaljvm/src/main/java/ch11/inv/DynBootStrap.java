package ch11.inv;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class DynBootStrap {
    public static CallSite bootstrap(Lookup lookup, String name, MethodType type, Object value) throws Exception {  
    	System.out.println("bootstrap called,name="+name);
        MethodHandle mh = lookup.findVirtual(value.getClass(), name, MethodType.methodType(int.class)).bindTo(value);
        return new ConstantCallSite(mh);  
    }  
}
