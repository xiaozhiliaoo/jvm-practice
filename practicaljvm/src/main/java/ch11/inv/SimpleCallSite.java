package ch11.inv;

import java.lang.invoke.*;

public class SimpleCallSite {
	
    public static void constantCallSiteSample0() throws Throwable {  
        MethodHandles.Lookup lookup = MethodHandles.lookup();  
        MethodType type = MethodType.methodType(String.class, int.class, int.class);  
        MethodHandle invoker = lookup.findVirtual(String.class, "substring", type);  
//        ConstantCallSite callSite = new ConstantCallSite(mh);  
//        MethodHandle invoker = callSite.dynamicInvoker();
        String result = (String) invoker.invoke("1234567890", 2, 4);
        System.out.println("constantCallSiteSample return:"+result);
    }
    
    public static void constantCallSiteSample() throws Throwable {  
        MethodHandles.Lookup lookup = MethodHandles.lookup();  
        MethodType type = MethodType.methodType(String.class, int.class, int.class);  
        MethodHandle mh = lookup.findVirtual(String.class, "substring", type);  
        ConstantCallSite callSite = new ConstantCallSite(mh);  
        MethodHandle invoker = callSite.dynamicInvoker();
        String result = (String) invoker.invoke("1234567890", 2, 4);
        System.out.println("constantCallSiteSample return:"+result);
    }
    
    public static void mutableCallSiteSample() throws Throwable {  
        MethodType type = MethodType.methodType(double.class, double.class);  
        MutableCallSite callSite = new MutableCallSite(type);  
        MethodHandle invoker = callSite.dynamicInvoker();  
        MethodHandles.Lookup lookup = MethodHandles.lookup();  
        MethodHandle mhSin = lookup.findStatic(Math.class, "sin", type);  
        MethodHandle mhCos = lookup.findStatic(Math.class, "cos", type);  
        callSite.setTarget(mhSin);  
        double result = (double) invoker.invoke(Math.PI/2); 
        System.out.println("sin(90)="+result);
        callSite.setTarget(mhCos);  
        result = (double) invoker.invoke(Math.PI/2);
        System.out.println("cos(90)="+result);
    } 
    
    public static void main(String[] args) throws Throwable {
    	constantCallSiteSample();
        mutableCallSiteSample();
    }
}
