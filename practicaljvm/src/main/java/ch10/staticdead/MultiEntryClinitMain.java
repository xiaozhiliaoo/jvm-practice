package ch10.staticdead;

/**
 * 多线程初始化一个类 只有一个线程会进入<clinit>
 * 其他等待的线程，在第一个线程完成后，并不会进入<clinit>
 * @author Administrator
 *
 */
public class MultiEntryClinitMain extends Thread{
	private char flag;
	public MultiEntryClinitMain(char flag){
		this.flag=flag;
		this.setName("Thread"+flag);
	}
	@Override
	public void run(){
		try {
			Class.forName("geym.zbase.ch10.staticdead.Static"+flag);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(getName()+" over");
	}
	public static void main(String[] args) throws InterruptedException {
		MultiEntryClinitMain loadA=new MultiEntryClinitMain('A');
		loadA.start();
		MultiEntryClinitMain loadB=new MultiEntryClinitMain('A');
		loadB.start();

	}

}

