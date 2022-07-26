import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> IntStream.range(0, 10_000_000).forEach((i) -> counter.inc()));
        Thread t2 = new Thread(() -> IntStream.range(0, 30_000_000).forEach((i) -> counter.inc()));

        // Since both threads are using the same value of counter instance,
        // There is thread interference

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        // Terminated the first thread before the 2nd thread starts will solve issue
        
        System.out.println(counter.getCount());
    }
}