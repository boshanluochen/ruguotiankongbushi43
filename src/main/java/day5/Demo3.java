package day5;

public class Demo3 {
    private static Object obj = new Object();

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.start();
        t2.start();
        t3.start();
        try {
            System.out.println(Thread.currentThread().getName() + " sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " notifyAll");
            obj.notifyAll();
        }

    }
    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait ");
                    obj.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
















//运行结果：
//    t1 wait
//    main sleep(3000)
//    t3 wait
//    t2 wait
//    main notifyAll()
//    t2 continue
//    t3 continue
//    t1 continue
//
//结果说明：
//    参考下面的流程图。
//    (01) 主线程中新建并且启动了3个线程"t1", "t2"和"t3"。
//    (02) 主线程通过sleep(3000)休眠3秒。在主线程休眠3秒的过程中，我们假设"t1", "t2"和"t3"这3个线程都运行了。
//         以"t1"为例，当它运行的时候，它会执行obj.wait()等待其它线程通过notify()或额nofityAll()来唤醒它；
//         相同的道理，"t2"和"t3"也会等待其它线程通过nofity()或nofityAll()来唤醒它们。
//    (03) 主线程休眠3秒之后，接着运行。执行 obj.notifyAll() 唤醒obj上的等待线程，即唤醒"t1", "t2"和"t3"这3个线程。
//         紧接着，主线程的synchronized(obj)运行完毕之后，主线程释放“obj锁”。这样，"t1", "t2"和"t3"就可以获取“obj锁”而继续运行了！









