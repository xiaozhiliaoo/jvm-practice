package ch8.jmm;
/**
 * -server
 * @author Administrator
 *
 */
public class VolatileTest {
	public static class MyThread extends Thread{
		private boolean stop = false;  	//确保stop变量在多线程中可见
		public synchronized void stopMe(){				//在其他线程中调用，停止本线程
			stop=true;
		}
		public synchronized boolean stopped(){
			return stop;
		}
		public void run() {
			int i = 0;
			while (!stopped()) { 					//在其他线程中改变stop的值
				i++;
			}
			System.out.println("Stop Thread");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
		Thread.sleep(1000);
		t.stopMe();
		Thread.sleep(1000);

	}
}


