package ch11.inst;

public class SyncAdd {
	private int i=0;
	public synchronized void add1(){
		i++;
	}
	
	public void add2(){
		synchronized(this){
			i++;
		}
	}
}
