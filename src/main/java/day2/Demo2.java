package day2;


public class Demo2 {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        System.out.println("currentThreadName: " + Thread.currentThread().getName());
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "t1");
        Thread t2 = new Thread(mt, "t2");
        Thread t3 = new Thread(mt, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

//结果说明：
//    (01) 和上面“MyThread继承于Thread”不同；这里的MyThread实现了Thread接口。
//    (02) 主线程main创建并启动3个子线程，而且这3个子线程都是基于“mt这个Runnable对象”而创建的。运行结果是这3个子线程一共卖出了10张票。这说明它们是共享了MyThread接口的。
