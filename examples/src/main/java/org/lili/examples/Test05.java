package org.lili.examples;

public class Test05 {

	public static void main(String[] args) {
		//初始的对象在eden区
		//参数：-Xmx64M -Xms64M -XX:+PrintGCDetails
//		for(int i=0; i< 5; i++){
//			byte[] b = new byte[1024*1024];
//		}
//
		
		
		//测试进入老年代的对象
		//
		//参数：-Xmx1024M -Xms1024M -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails 
		//-XX:+PrintHeapAtGC
//		Map<Integer, byte[]> m = new HashMap<Integer, byte[]>();
//		for(int i =0; i <5 ; i++) {
//			byte[] b = new byte[1024*1024];
//			m.put(i, b);
//		}
//		
		for(int k = 0; k<20; k++) {
			for(int j = 0; j<300; j++){
				byte[] b = new byte[1024*1024];
			}
		}
		
	
	}
}
