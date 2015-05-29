package multithreading;

public class MyThreadLocal implements Runnable {
	
	ThreadLocal<Double> threadLocal = new ThreadLocal<Double>();
	
	public static void main(String[] args){
		MyThreadLocal instance = new MyThreadLocal();
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		
	}

	@Override
	public void run() {
		threadLocal.set(Math.random());
		System.out.println(threadLocal.get());
	}

}
