package day5;

import javax.swing.plaf.TableHeaderUI;

public class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前wait的线程
            notify();
        }
    }
}
