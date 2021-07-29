package Day7;

public class ThreadA extends Thread {
    public ThreadA (String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: %d\n", this.getName(), i);
                if (i % 4 == 0) {
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
