package ch11.jit;

public class C1C2TimeMain {
	public static double calcPi(){
		double re=0;
		for(int i=1;i<10000;i++){
			re+=((i&1)==0?-1:1)*1.0/(2*i-1);
		}
		return re*4;
	}
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(20000);
		long b=System.currentTimeMillis();
		for(int i=0;i<10000;i++)
			calcPi();		
		long e=System.currentTimeMillis();
		System.out.println("spend:"+(e-b)+"ms");
		
	}
}
