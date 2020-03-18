package ch8.jmm;

/**
 * @author Administrator
 *
 */
public class MultiThreadVolatileLong {
	public static volatile long t=0;
	public static class ChangeT implements Runnable{
		private long to;
		public ChangeT(long to){
			this.to=to;
		}
		@Override
		public void run() {
			while(true){
			MultiThreadVolatileLong.t=to;
			Thread.yield();
			}
		}
	}
	public static class ReadT implements Runnable{
		@Override
		public void run() {
			while(true){
			 long tmp=MultiThreadVolatileLong.t;
			 if(tmp!=111L && tmp!=-999L && tmp!=333L && tmp!=-444L)
			     System.out.println(tmp);
			Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(Long.toBinaryString(111L));
//		System.out.println(Long.toBinaryString(-999L));
//		System.out.println(Long.toBinaryString(333L));
//		System.out.println(Long.toBinaryString(-444L));
//		System.out.println(Long.toBinaryString(4294966297L));
//		System.out.println(Long.toBinaryString(-4294967185L));
		
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();
	}
}
