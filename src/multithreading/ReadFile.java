package multithreading;

import java.util.concurrent.*;

/**
 * Created by swathi on 9/28/14.
 */
public class ReadFile {

    public static void main(String[]args) throws InterruptedException,ExecutionException    {
        int threadCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(200);
        CountDownLatch latch = new CountDownLatch(1);

        while(threadCount > 0){
            System.out.println("Inside thread creation");
            executorService.submit(new CpuTask(queue,latch));
            threadCount--;
        }

        executorService.submit(new FetchTask(queue,latch)).get();

        executorService.shutdownNow();
        executorService.awaitTermination(365, TimeUnit.DAYS);

        try{
            latch.await();;
        }catch(InterruptedException e){

        }

    }
}