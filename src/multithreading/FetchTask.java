package multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by swathi on 9/28/14.
 */
public class FetchTask implements Runnable {

    BlockingQueue<String> queue;
    CountDownLatch latch;

    public FetchTask(BlockingQueue<String> queue,CountDownLatch latch){
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("multithreading/testFile.txt"));
            String line;
            while((line = bufferedReader.readLine())!=null){
                queue.offer(line);
            }

        latch.countDown();
        }catch (IOException e){

        }

    }

}