package multithreading;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.print("overridden");
	}
	
	public static void main(String []args){
		MyThread thread = new MyThread();
		thread.start();
	}
	

	
}
