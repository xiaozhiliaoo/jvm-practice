package ch11.jit.inline;

/**
 * @author Administrator
 *
 */
public class InLineMain {
	static int i=0;
	public static void inc(){
		i++;
	}
	public static void main(String[] args) {
		long b=System.currentTimeMillis();
		for(int j=0;j<100000000;j++){
			inc();
		}
		long e=System.currentTimeMillis();
		System.out.println(e-b);
	}
}
