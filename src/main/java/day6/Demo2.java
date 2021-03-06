package day6;

public class Demo2 {
    private static Object obj = new Object();

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    if (i % 4 == 0) {
                        Thread.yield();
                    }
                }
            }
        }
    }
}

//运行结果：
//    t1 [5]:0
//    t1 [5]:1
//    t1 [5]:2
//    t1 [5]:3
//    t1 [5]:4
//    t1 [5]:5
//    t1 [5]:6
//    t1 [5]:7
//    t1 [5]:8
//    t1 [5]:9
//    t2 [5]:0
//    t2 [5]:1
//    t2 [5]:2
//    t2 [5]:3
//    t2 [5]:4
//    t2 [5]:5
//    t2 [5]:6
//    t2 [5]:7
//    t2 [5]:8
//    t2 [5]:9
//结果说明：
//    主线程main中启动了两个线程t1和t2。t1和t2在run()会引用同一个对象的同步锁，即synchronized(obj)。
//    在t1运行过程中，虽然它会调用Thread.yield()；但是，t2是不会获取cpu执行权的。因为，t1并没有释放“obj所持有的同步锁”！
