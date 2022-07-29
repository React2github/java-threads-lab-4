public class Counter {

  long count = 0;

  // since count is a non-atomic operation, and it is a critical section
  // we need to synchronize our instance method

  public synchronized void inc() {

      count++;
  }

  public long getCount() {

      return count;
  }
}