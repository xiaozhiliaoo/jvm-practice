package ch8.biased;

import java.util.List;
import java.util.Vector;

/**
 * @author Geym
 *
 */
public class ThreadSafe {
	public static List<Integer> numberList =new Vector<Integer>();
	
	
	public static class AddToList implements Runnable{
		int startnum=0;
		public AddToList(int startnumber){
			startnum=startnumber;
		}
		@Override
		public void run() {
			int count=0;
			while(count<10000000){
				numberList.add(startnum);
				startnum+=2;
				count++;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new AddToList(0));
		Thread t2=new Thread(new AddToList(1));
		long begin=System.currentTimeMillis();
		t1.start();
		t2.start();
		
		while(t1.isAlive() || t2.isAlive()){
			Thread.sleep(1);
		}
		long end=System.currentTimeMillis();
		System.out.println(end-begin);
	}

}
