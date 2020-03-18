package ch11.inst;

import java.util.Date;

public class InvokeCode {

	private void pMethod(){
		
	}
	public void invokeVirtual(){
		System.out.println("aa");
	}
	
	public void invokeSpecial1(){
		Date d=new Date();
	}
	public void invokeSpecial2(){
		pMethod();
	}
	
	public void invokeSpecial3(){
		super.toString();
	}
	
	public void invokeInterface(){
		Thread t=new Thread();
		t.run();
		((Runnable)t).run();
	}
	
	public static interface IAdd{
		long add(long a, long b, long c);
	}
	public void invokeInterface2(){
		IAdd c=null;
		c.add(1, 1,2);
	}
	
	public void invokeStatic(){
		Math.abs(-1);
	}
	
	@Override
	public String toString(){
		return "";
	}
}
