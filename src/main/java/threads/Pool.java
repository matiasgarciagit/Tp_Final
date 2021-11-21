package threads;

import start.Util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Pool {

    private final ThreadPoolExecutor executor;

    public Pool() {
       // executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Util.getNumber());

        //RejectedTaskController controller=new RejectedTaskController();
        //executor.setRejectedExecutionHandler(controller);
    }

    public void executeTask(Task task) {
        executor.execute(task);

    }


    public void apagar() {
        executor.shutdown(); // o shutdownNow?
    }
}