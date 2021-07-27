package day4;

public class Demo8 {
    Something x = new Something();
    Something y = new Something();

    private void test() {
        Thread t11 = new Thread(new Runnable() {
            public void run() {
                x.isSyncA();
            }
        }, "t11");
        Thread t22 = new Thread(new Runnable() {
            public void run() {
                y.isSyncA();
            }
        }, "t22");
        t11.start();
        t22.start();
    }

    public static void main(String[] args) {
        Demo8 demo = new Demo8();
        demo.test();
    }
}

//运行结果：
//    t21 : isSyncA
//    t22 : isSyncA
//    t21 : isSyncA
//    t22 : isSyncA
//    t21 : isSyncA
//    t22 : isSyncA
//    t21 : isSyncA
//    t22 : isSyncA
//    t21 : isSyncA
//    t22 : isSyncA
//
//可以同时被访问。因为访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，
//而y.isSyncA()访问的是y的同步锁。