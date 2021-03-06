package day4;

public class Demo3 {
    public static void main(String[] args) {
        final Count1 count = new Count1();
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
//
//    t1 synMethod loop 0
//    t2 nonSynMethod loop 0
//    t1 synMethod loop 1
//    t2 nonSynMethod loop 1
//    t1 synMethod loop 2
//    t2 nonSynMethod loop 2
//    t1 synMethod loop 3
//    t2 nonSynMethod loop 3
//    t1 synMethod loop 4
//    t2 nonSynMethod loop 4
//
//结果说明：
//    主线程中新建了两个子线程t1和t2。t1会调用count对象的synMethod()方法，该方法内含有同步块；
//    而t2则会调用count对象的nonSynMethod()方法，该方法不是同步方法。t1运行时，
//    虽然调用synchronized(this)获取“count的同步锁”；但是并没有造成t2的阻塞，
//    因为t2没有用到“count”同步锁。