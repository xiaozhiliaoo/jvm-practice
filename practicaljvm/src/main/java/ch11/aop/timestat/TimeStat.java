package ch11.aop.timestat;

public class TimeStat { 
     static ThreadLocal<Long> t=new ThreadLocal<Long>();
	 public static void start() { 
		 t.set(System.currentTimeMillis());
	 } 	
	 
	 public static void end(){
	     long time=System.currentTimeMillis()-t.get();
	     System.out.print(Thread.currentThread().getStackTrace()[2]+" spend:");        
	     System.out.println(time);
	 }
}
