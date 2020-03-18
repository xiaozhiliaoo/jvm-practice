package ch11.inv;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * invokeSpecial
 * @author Administrator
 *
 */
public class SimplePrivateMethodHandle{
	public static void main(String[] args) throws Throwable {
		SimplePrivateMethodHandle obj = new SimplePrivateMethodHandle();
		obj.callToString();
	}

	private void printLine() {
		System.out.println("call private method");
	}

	public void callToString() throws Throwable {
		MethodHandle mh = MethodHandles.lookup().findSpecial(this.getClass(), "printLine",
				MethodType.methodType(void.class), this.getClass()).bindTo(this);
		mh.invokeExact();
	}
}