package ch11.aop.securitycheck;

public class SecurityChecker { 
	 public static boolean checkSecurity() { 
		 System.out.println("SecurityChecker.checkSecurity ...");
		 if((System.currentTimeMillis()&0x1)==0)
		     return false;
		 else
		     return true;
	 } 	
}
