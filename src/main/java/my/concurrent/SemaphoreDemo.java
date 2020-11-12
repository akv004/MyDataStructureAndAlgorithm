package my.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Semaphore is used to restrict/manage the use of limited resources.
 * Example if you have slow rest service and you have number of threads
 * that is calling it. you can use it as following
 */
public class SemaphoreDemo {


    public static void main(String args[]) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i-> service.execute(new Task(semaphore)));

        service.shutdown();
        service.awaitTermination( 1, TimeUnit.MINUTES);

    }
    static class Task implements Runnable {
       Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            //some processing
            semaphore.acquireUninterruptibly();
            //some processing IO to call slow service
            semaphore.release(); // Release permit back
            //rest of precessing.
        }
    }

}
