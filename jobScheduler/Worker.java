package jobsch;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Worker implements Runnable {
    Instant current = Instant.now();
    DelayQueue<Job> jobsQueue = new DelayQueue<>();
    @Override
    public void run(){
        while(true){
            try{
                Job jobAtTop = jobsQueue.take();
                try{
                    jobAtTop.run();
                }catch(Exception e){
                    jobsQueue.add(jobAtTop);
                }
            }catch(Exception e){
                System.err.println("Exception due to "+e.getMessage());
            }
            
        }
    }
}
