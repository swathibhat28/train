package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by swathi on 9/28/14.
 */
public class CpuTask implements Runnable{

    BlockingQueue<String> queue;
    CountDownLatch latch;

    public CpuTask(BlockingQueue<String>queue,CountDownLatch latch){
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run(){
        String line;
        while(true){
            try{
                queue.take();

            }catch (InterruptedException e){
                latch.countDown();
                break;
            }
        }

        while((line = queue.poll())!=null){
            System.out.println(line);
        }




    }
}
