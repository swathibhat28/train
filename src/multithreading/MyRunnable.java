package multithreading;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
	
	public static void main(String []args){
		System.out.println(Thread.currentThread().getName());
		for(int i=1;i<=10;i++){
			Thread thread = new Thread( new MyRunnable(),""+i);
			thread.start();
		}
	}

}
