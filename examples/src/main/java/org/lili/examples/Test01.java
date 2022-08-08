package org.lili.examples;


public class Test01 {

	public static void main(String[] args) {

//		System.out.println(args[0]);
//		System.out.println(args[1]);

		//-Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		
		//查看GC信息
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
		
		byte[] b1 = new byte[1*1024*1024];
		System.out.println("分配了1M");
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
		
		byte[] b2 = new byte[4*1024*1024];
		System.out.println("分配了4M");
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());

		int a = 0x00000000fec00000;
		int b = 0x00000000fee10000;
		System.out.println((b-a)/1024);
		for (;;){}
		
	}
	
}
