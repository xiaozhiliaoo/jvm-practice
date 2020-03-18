package ch11.agent.attach;


import ch11.aop.timestat.Account;

public class RunLoopAccountMain {
	 public static void main(String[] args) { 
		 Account account = new Account();
		 while(true){
		     account.operation();
		     try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		 }
	 } 
}
