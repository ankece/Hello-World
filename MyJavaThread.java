package myThreads;

public class MyThread {

	public static void main(String[] args) throws InterruptedException {
		
		Counter obj = new Counter();
		Thread th1 = new Thread() {
			
			public void run() {
				obj.setCount(5);
				System.out.println("Counter value =>"+ obj.getCount()+" Thread1 => "+ Thread.currentThread().getName());
			}
		};
		
		Thread th2 = new Thread() {
			
			public void run(){
			try {
				//Thread.sleep(500);
				obj.setCount(2);
				System.out.println("Counter value =>"+ obj.getCount()+" Thread2 => "+ Thread.currentThread().getName());
			}
			catch(Exception ex){}
			}
		};
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
		
		
	}

}

class Counter {
	
	int count;
	
	public Counter() {
		this.count = 0;
	}
	
	public synchronized void setCount(final int cnt) {
		    System.out.println("setCount -->"+Thread.currentThread().getName());
			this.count = cnt;
	}
	
	public synchronized int getCount() {
		System.out.println("getCount -->"+Thread.currentThread().getName());
		return this.count;
	}
}
