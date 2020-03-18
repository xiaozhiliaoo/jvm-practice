package ch6.hold;

import java.util.Map;
import java.util.WeakHashMap;

/**
 *
-Djava.rmi.server.hostname=127.0.0.1
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.port=8888
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.ssl=false
 * @author Administrator
 *
 */
public class HoldMemoryMain {	
	public static class HoldMemoryTask implements Runnable{
		static Map<Long,byte[]> map=new WeakHashMap<Long,byte[]>();

		public void run() {
			try{
				while(true){
					map.put(System.nanoTime(), new byte[512]);
					Thread.sleep(1);
				}
			}catch(Exception e){
				
			}
		}
	}
	
	public static void main(String[] args){
		new Thread(new HoldMemoryTask()).start();
	}
}

