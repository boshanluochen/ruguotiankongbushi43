package day5;

public class ThreadA1 extends Thread {
    public ThreadA1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run ");
        // 死循环
        while (true) {

        }
    }
}
