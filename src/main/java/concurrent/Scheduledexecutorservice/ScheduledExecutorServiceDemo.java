package concurrent.Scheduledexecutorservice;

import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(() -> {
            System.out.println("I'm working!!!");
        }, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("I'm working!!!");
        }, 2, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("I'm working!!!");
        }, 3, 1, TimeUnit.SECONDS);

        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(() -> {
            System.out.println("I'm working!!!");
            return "Hello";
        }, 3, TimeUnit.SECONDS);

        while (!schedule.isDone()) {
            System.out.println("She is working!!!");
        }

        System.out.println(schedule.get());


        scheduledExecutorService.shutdown();
    }
}
