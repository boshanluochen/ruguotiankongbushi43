package day4;

public class Demo4 {
    public static void main(String[] args) {
        final Count2 count = new Count2();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                count.synMethod();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                count.nonSynMethod();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}

//运行结果：
//    t1 synMethod loop 0
//    t1 synMethod loop 1
//    t1 synMethod loop 2
//    t1 synMethod loop 3
//    t1 synMethod loop 4
//    t2 nonSynMethod loop 0
//    t2 nonSynMethod loop 1
//    t2 nonSynMethod loop 2
//    t2 nonSynMethod loop 3
//    t2 nonSynMethod loop 4
//结果说明：
//    主线程中新建了两个子线程t1和t2。t1和t2运行时都调用synchronized(this)，这个this是Count对象(count)，
//    而t1和t2共用count。因此，在t1运行时，t2会被阻塞，等待t1运行释放“count对象的同步锁”，t2才能运行。