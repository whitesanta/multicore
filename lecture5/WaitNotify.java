package multicore.lecture5;

public class WaitNotify {
    public static void main(String args[]) throws InterruptedException {
        Object lock = new Object();
        lock.wait();
    }
}