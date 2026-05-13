package questions.threadPool;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(3);

        threadPool.submit(()->{
            System.out.println("submitted a new task");
        });
        List<Task> tasks = List.of(
                ()-> System.out.println("Task 1 is running..."),
                ()-> System.out.println("Task 2 is running..."),
                ()-> System.out.println("Task 3 is running...")
        );

        tasks.forEach(task -> threadPool.submit(task));
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
        threadPool.shutdown();
    }
}
