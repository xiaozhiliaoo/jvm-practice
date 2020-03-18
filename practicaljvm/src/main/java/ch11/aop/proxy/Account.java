package ch11.aop.proxy;

public class Account {
	public String query() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return "result";
	}
}
