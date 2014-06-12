package multicore.lecture05;

import java.util.concurrent.CountDownLatch;

public class WaitSet {
    
    public static void main(String[] arg) throws InterruptedException {
        final Object lock = new Object();
        final CountDownLatch latch = new CountDownLatch(1);
        
        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized(lock) {
                    latch.countDown();
                    try {
                        lock.wait();
                    } catch (InterruptedException ignore) { /*NOP*/}
                }
            }
        }, "WaitSet Program");
        
        thread.start();
        latch.await();
        System.out.println("Thread state: " + thread.getState());
    }
}