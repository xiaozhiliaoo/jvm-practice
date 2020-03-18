package ch11.aop.securitycheck;

public class Account_Dst { 
	 public void operation() {
	     if(!SecurityChecker.checkSecurity())
	         return;
		 System.out.println("operation......"); 
	 } 
}
