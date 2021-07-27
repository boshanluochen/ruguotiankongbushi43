package day4;

public class Demo10 {
    Something x = new Something();

    private void test() {
        Thread t41 = new Thread(new Runnable() {
            public void run() {
                x.isSyncA();
            }
        }, "t41");
        Thread t42 = new Thread(new Runnable() {
            public void run() {
                x.cSyncA();
                //Something.cSyncA();
            }
        }, "t42");
        t41.start();
        t42.start();
    }

    public static void main(String[] args) {
        Demo10 demo = new Demo10();
        demo.test();
    }
}

//运行结果：
//    t41 : isSyncA
//    t42 : cSyncA
//    t41 : isSyncA
//    t42 : cSyncA
//    t41 : isSyncA
//    t42 : cSyncA
//    t41 : isSyncA
//    t42 : cSyncA
//    t41 : isSyncA
//    t42 : cSyncA
//可以被同时访问。因为isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；
//而cSyncA()是静态方法，Something.cSyncA()可以理解对使用的是“类的锁”。因此，它们是可以被同时访问的。
