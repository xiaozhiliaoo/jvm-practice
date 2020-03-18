package ch10.clshot;

import java.lang.reflect.Method;

public class DoopRun {
	public static void main(String args[]) {
		while(true){
			try{
				MyClassLoader loader = new MyClassLoader("D:/tmp/clz");
				Class cls = loader.loadClass("geym.zbase.ch10.clshot.DemoA");
				Object demo = cls.newInstance();
		
				Method m = demo.getClass().getMethod("hot", new Class[] {});
				m.invoke(demo, new Object[] {});
				Thread.sleep(10000);
			}catch(Exception e){
				System.out.println("not find");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
				}
			}
		}
	}
}
