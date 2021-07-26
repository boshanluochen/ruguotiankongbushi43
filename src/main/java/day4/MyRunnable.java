package day4;

public class MyRunnable implements Runnable {
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    // 休眠100ms
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
