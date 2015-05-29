package multithreading; /**
 * Created by swathi on 9/28/14.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ProcessLargeFile {

    public static void main(String[] args) throws IOException{


        processDependentBlocks();

    }

    private static void processDependentBlocks() throws IOException {
        ExecutorService executerService = Executors.newFixedThreadPool(1);
        RandomAccessFile in = new RandomAccessFile("multithreading/testFile.txt","r");
        in.seek(0L);
        while(in.getFilePointer() < in.length()){
            int readSize = (int)Math.min(100000,in.length()-in.getFilePointer());
            final byte[] data = new byte[readSize];
            in.readFully(data);
            executerService.execute(new Runnable() {
                @Override
                public void run() {
                    //do whatever processing
                }
            });

        }
    }
}