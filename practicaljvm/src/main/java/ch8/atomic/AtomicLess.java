package ch8.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLess {
	private static final int MAX_THREADS = 3;					//线程数
	private static final int TASK_COUNT = 3;						//任务数
	private static final int TARGET_COUNT = 10000000;				//目标总数

	private AtomicLong acount =new AtomicLong(0L);			//无锁的原子操作
	private long count=0;

	static CountDownLatch cdlsync=new CountDownLatch(TASK_COUNT);
	static CountDownLatch cdlatomic=new CountDownLatch(TASK_COUNT);

	protected synchronized long inc(){							//有锁的加法
		return ++count;
	}

	protected synchronized long getCount(){						//有锁的操作
		return count;
	}

	public void clearCount(){
		count=0;
	}

	public class SyncThread implements Runnable{
		protected String name;
		protected long starttime;
		AtomicLess out;										// TestAtomic为当前类名
		public SyncThread(AtomicLess o,long starttime){
			out=o;
			this.starttime=starttime;
		}
		@Override
		public void run() {
			long v=out.getCount();
			while(v<TARGET_COUNT){						//在到达目标值前，不停循环
				v=out.inc();
			}
			long endtime=System.currentTimeMillis();
			System.out.println("SyncThread spend:"+(endtime-starttime)+"ms"+" v="+v);
			cdlsync.countDown();
		}
	}

	public void testSync() throws InterruptedException{
		ExecutorService exe=Executors.newFixedThreadPool(MAX_THREADS);
		long starttime=System.currentTimeMillis();
		SyncThread sync=new SyncThread(this,starttime);
		for(int i=0;i<TASK_COUNT;i++){
			exe.submit(sync); 								//提交线程开始计算
		}
		cdlsync.await();
		exe.shutdown();
	}
	public class AtomicThread implements Runnable{
		protected String name;
		protected long starttime;
		public AtomicThread(long starttime){
			this.starttime=starttime;
		}
		@Override
		public void run() {									//在到达目标值前，不停循环
			long v=acount.get();
			while(v<TARGET_COUNT){
				v=acount.incrementAndGet();					//无锁的加法
			}
			long endtime=System.currentTimeMillis();
			System.out.println("AtomicThread spend:"+(endtime-starttime)+"ms"+" v="+v);
			cdlatomic.countDown();
		}
	}

	public void testAtomic() throws InterruptedException{
		ExecutorService exe=Executors.newFixedThreadPool(MAX_THREADS);
		long starttime=System.currentTimeMillis();
		AtomicThread atomic=new AtomicThread(starttime);
		for(int i=0;i<TASK_COUNT;i++){
			exe.submit(atomic);								//提交线程开始计算
		}
		cdlatomic.await();
		exe.shutdown();
	}

	public static void main(String args[]) throws InterruptedException{
		AtomicLess a=new AtomicLess();
		a.testSync();
		a.testAtomic();
	}
}
