package ch10.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionMain {
	public static void main(String[] args) throws Exception {
		Class clzStr=Class.forName("java.lang.String");
		Method[] ms=clzStr.getDeclaredMethods();
		for(Method m:ms){
			String mod=Modifier.toString(m.getModifiers());
			System.out.print(mod+" "+ m.getName()+" (");
			Class<?>[] ps=m.getParameterTypes();
			if(ps.length==0)System.out.print(')');
			for(int i=0;i<ps.length;i++){
				char end=i==ps.length-1?')':',';
				System.out.print(ps[i].getSimpleName()+end);
			}
			System.out.println();
		}
	}
}
