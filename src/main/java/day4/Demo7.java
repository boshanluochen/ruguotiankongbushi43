package day4;

public class Demo7 {
    Something x = new Something();

    private void test() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                x.isSyncA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                x.isSyncB();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        Demo7 demo = new Demo7();
        demo.test();
    }
}

//运行结果：
//    t11 : isSyncA
//    t11 : isSyncA
//    t11 : isSyncA
//    t11 : isSyncA
//    t11 : isSyncA
//    t12 : isSyncB
//    t12 : isSyncB
//    t12 : isSyncB
//    t12 : isSyncB
//    t12 : isSyncB
//
//不能被同时访问。因为isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！