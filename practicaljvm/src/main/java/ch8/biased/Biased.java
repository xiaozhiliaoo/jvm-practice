package ch8.biased;

import java.util.List;
import java.util.Vector;

/**
 * @author Geym
 *
 */
public class Biased {
	public static List<Integer> numberList =new Vector<Integer>();
	public static void main(String[] args) throws InterruptedException {
		long begin=System.currentTimeMillis();
		int count=0;
		int startnum=0;
		while(count<10000000){
			numberList.add(startnum);
			startnum+=2;
			count++;
		}
		long end=System.currentTimeMillis();
		System.out.println(end-begin);
	}
}
