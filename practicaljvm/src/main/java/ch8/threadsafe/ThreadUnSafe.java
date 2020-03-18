package ch8.threadsafe;

import java.util.ArrayList;
import java.util.List;

public class ThreadUnSafe {
	public static List<Integer> numberList =new ArrayList<Integer>();
	public static class AddToList implements Runnable{
		int startnum=0;
		public AddToList(int startnumber){
			startnum=startnumber;
		}
		@Override
		public void run() {
			int count=0;
			while(count<1000000){
				numberList.add(startnum);
				startnum+=2;
				count++;
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new AddToList(0));
		Thread t2=new Thread(new AddToList(1));
		t1.start();
		t2.start();
	}
}
