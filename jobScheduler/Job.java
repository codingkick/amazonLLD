package jobsch;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Job implements Delayed {
    public long executionTime;

    public void run() throws Exception{

        throw new Exception("he");
    }

    @Override
    public long getDelay(TimeUnit unit){
        long remaining = executionTime-System.nanoTime();
        return unit.convert(remaining, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other){
        return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), other.getDelay(TimeUnit.NANOSECONDS));
    }
}
