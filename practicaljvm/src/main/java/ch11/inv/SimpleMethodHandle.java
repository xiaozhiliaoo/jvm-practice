package ch11.inv;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class SimpleMethodHandle {
    static class MyPrintln {
        protected void println(String s) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable {
        Object obj = (System.currentTimeMillis() & 1L) == 0L ? System.out : new MyPrintln();
        System.out.println(obj.getClass().toString());
        getPrintlnMethodHandler(obj).invokeExact("geym");
    }
    private static MethodHandle getPrintlnMethodHandler(Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);
        
        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
}
