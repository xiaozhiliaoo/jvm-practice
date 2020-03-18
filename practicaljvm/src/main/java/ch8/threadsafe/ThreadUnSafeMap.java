package ch8.threadsafe;

import java.util.HashMap;
import java.util.Map;

public class ThreadUnSafeMap {
	public static Map<String,String> hashMap =new HashMap<String,String>();
	public static class AddToMap implements Runnable{
		int startnum=0;
		public AddToMap(int startnumber){
			startnum=startnumber;
		}
		@Override
		public void run() {
			int count=0;
			while(count<10000){
			    hashMap.put(Integer.toString(startnum),Integer.toBinaryString(startnum));
				startnum+=2;
				count++;
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new AddToMap(0));
		Thread t2=new Thread(new AddToMap(1));
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive()){
			Thread.sleep(1);
		}
		System.out.println("Add Data Complete!");
		for(int i=0;i<10000;i++){
		    System.out.println(hashMap.get(Integer.toString(i)));
		}
	}
}
