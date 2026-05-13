package questions.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final LinkedBlockingQueue<Task> taskQueue;
    private final List<Thread> workerThreads;
    private static final Task poison_pill_task = ()->{};
    CustomThreadPool(int numThreads) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workerThreads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            workerThreads.add(new CustomThread(taskQueue, poison_pill_task));
        }
        startThreads();
    }

    private void startThreads() {
        for (Thread worker : workerThreads) {
            worker.start();
        }
    }

    public void shutdown() {
        try{
            for (Thread worker : workerThreads) {
                taskQueue.put(poison_pill_task);
            }
        }
        catch(InterruptedException e){
            System.err.println("Interrupted due to "+e.getMessage());
        }
    }

    public void submit(Task task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Failed to submit task due to interruption: " + e.getMessage());
        }
    }
}
