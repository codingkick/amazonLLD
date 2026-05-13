package questions.threadPool;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThread extends Thread {
    private LinkedBlockingQueue<Task> taskQueue;
    private final Task poison_pill_task;
    CustomThread(LinkedBlockingQueue<Task> taskQueue, Task poison_pill_task) {
        this.taskQueue = taskQueue;
        this.poison_pill_task = poison_pill_task;
    }
    @Override
    public void run() {
        while(true){
            try {
                Task task = taskQueue.take();
                if(task == poison_pill_task)
                    break;
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Custom thread interrupted: " + e.getMessage());
                break; // Exit the loop if interrupted
            }
        }
    }
}
