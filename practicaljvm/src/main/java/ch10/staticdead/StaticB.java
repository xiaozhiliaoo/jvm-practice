package ch10.staticdead;

public class StaticB {
	static{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		try {
			Class.forName("geym.zbase.ch10.staticdead.StaticA");
		} catch (ClassNotFoundException e) {
		}
		System.out.println("StaticB init OK");
	}
}
