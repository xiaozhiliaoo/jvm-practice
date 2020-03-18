package ch8.lockcoarsenn;

public class LockCoarsen {
	public static Object lock=new Object();
	public static final int CIRCLE=10000000;
	
	public static void main(String[] args) {

	
		long begintime=System.currentTimeMillis();
		for(int i=0;i<CIRCLE;i++){
			synchronized(lock){
				
			}
		}
		long endtime=System.currentTimeMillis();
		System.out.println("sync in loop:"+(endtime-begintime));
		
		long begintime1=System.currentTimeMillis();
		synchronized(lock){
			for(int i=0;i<CIRCLE;i++){
				
			}
		}
		long endtime1=System.currentTimeMillis();
		System.out.println("sync out loop:"+(endtime1-begintime1));

	}

}
