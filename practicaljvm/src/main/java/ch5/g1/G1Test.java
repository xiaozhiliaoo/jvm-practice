package ch5.g1;

import java.util.HashMap;

/**
 * -Xmx200m -Xms200m -XX:+UseG1GC -Xloggc:gc.log -XX:+PrintGCDetails -XX:MaxGCPauseMillis=2000 -XX:+PrintTenuringDistribution
 * @author Administrator
 *
 */
public class G1Test {
	public static class MyThread extends Thread{
		HashMap map=new HashMap();
		@Override
		public void run(){
			try{
				while(true){
					byte[] b1;
					if(map.size()*512/1024/1024>=200){
						map.clear();

						System.out.println("clean map");
					}
					for(int i=0;i<1000;i++){
						b1=new byte[512];
						map.put(System.nanoTime(), b1);
						for(int j=0;j<1000;j++){
							byte[] b2=new byte[10];
						}
					}
					Thread.sleep(1);
				}
			}catch(Exception e){
				
			}
		}
	}
	public static class PrintThread extends Thread{
		public static final long starttime=System.currentTimeMillis();
		@Override
		public void run(){
			try{
				while(true){
					long t=System.currentTimeMillis()-starttime;
					System.out.println(t/1000+"."+t%1000);
					Thread.sleep(100);
//					byte[] b=new byte[1024*1024*3];
				}
			}catch(Exception e){
				
			}
		}
	}
	public static void main(String args[]){
		MyThread t=new MyThread();
		PrintThread p=new PrintThread();
		t.start();
		p.start();
	}
}
