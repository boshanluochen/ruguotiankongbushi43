package day6;

public class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            if (i % 4 == 0) {
                Thread.yield();
            }
        }
    }
}
