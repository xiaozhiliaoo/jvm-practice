package ch11.inv;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * -Xcomp -XX:-BackgroundCompilation
 * 
 * @author Administrator
 *
 */
public class RelectionMain {
	public static final int COUNT = 1000000;
	int i = 0;

	public void method() {
		i++;
	}

	public static void callByHandler() throws Throwable {
		RelectionMain instance = new RelectionMain();
		MethodType mt = MethodType.methodType(void.class);
		MethodHandle mh = lookup().findVirtual(instance.getClass(), "method", mt).bindTo(instance);
		long b = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			mh.invokeExact();
		}
		long e = System.currentTimeMillis();
		System.out.println("callByHandler spend:"+(e - b));
	}

	public static void callByReflection() throws Throwable {
		RelectionMain instance = new RelectionMain();
		Method m = instance.getClass().getMethod("method");
		long b = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			m.invoke(instance);
		}
		long e = System.currentTimeMillis();
		System.out.println("callByReflection spend:"+(e - b));
	}

	public static void main(String[] args) throws Throwable {
		callByHandler();
		callByHandler();
		callByReflection();
		callByReflection();
	}
}
