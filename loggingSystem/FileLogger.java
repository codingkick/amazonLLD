package questions.loggingSystem;

import java.util.concurrent.LinkedBlockingQueue;

public class FileLogger implements Logger,Runnable{
    private LinkedBlockingQueue<Log> logQueue;
    FileLogger(LinkedBlockingQueue<Log> logQueue) {
        this.logQueue = logQueue;
    }
    @Override
    public void log() {
        try {
            while (true) {
                System.out.println("FileLogger is waiting for logs...");
                Log log = logQueue.take();
                // Simulate writing log to file
                if(log.getMessage().equals("EXIT"))
                    Thread.currentThread().interrupt();
                System.out.println("log file output" + log.getMessage());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("FileLogger interrupted: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        log();
    }
}
