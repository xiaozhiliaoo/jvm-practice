package ch11.aop.timestat;

public class Account { 
	 public void operation() { 
		 System.out.println("operation....");
		 try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	 } 
}
 