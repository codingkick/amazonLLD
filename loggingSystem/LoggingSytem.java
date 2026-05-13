package questions.loggingSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class LoggingSytem {
    private static volatile LoggingSytem instance;
    private LinkedBlockingQueue<Log> logQueue;
    private final AtomicLong logIdGenerator;
    private final ExecutorService executorService;

    private LoggingSytem() {
        // Private constructor to prevent instantiation
        this.logQueue = new LinkedBlockingQueue<>();
        this.logIdGenerator = new AtomicLong(0);
        this.executorService = Executors.newFixedThreadPool(1);
        this.executorService.submit(new FileLogger(logQueue));
    }

    public static LoggingSytem getInstance() {
        if (instance == null) {
            synchronized(LoggingSytem.class) {
                if (instance == null) {
                    instance = new LoggingSytem();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        try {
            System.out.println("input log here: " + message);
            logQueue.put(new Log(String.valueOf(logIdGenerator.incrementAndGet()), message, LogLevel.INFO));
        } catch (Exception e) {
            System.err.println("Failed to log due to exception: " + e.getMessage());
        }
    }

    public void shutdown() {
        this.executorService.shutdown();
    }
}
