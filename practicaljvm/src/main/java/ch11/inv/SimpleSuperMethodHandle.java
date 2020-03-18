package ch11.inv;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * invokeSpecial call parent method
 * @author Administrator
 *
 */
public class SimpleSuperMethodHandle{
	public static void main(String[] args) throws Throwable {
		SimpleSuperMethodHandle obj = new SimpleSuperMethodHandle();
		System.out.println(obj.callToString());
	}

	@Override
	public String toString() {
		return "I am SimpleSuperMethodHandle";
	}

	public String callToString() throws Throwable {
		MethodHandle mh = MethodHandles.lookup().findSpecial(Object.class, "toString",
				MethodType.methodType(String.class), this.getClass()).bindTo(this);
		String a = (String) mh.invokeExact();
		return a;
	}
}