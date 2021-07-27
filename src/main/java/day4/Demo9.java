package day4;

public class Demo9 {
    Something x = new Something();
    Something y = new Something();

    private void test() {
        Thread t31 = new Thread(new Runnable() {
            public void run() {
                x.cSyncA();
            }
        }, "t31");
        Thread t32 = new Thread(new Runnable() {
            public void run() {
                y.cSyncA();
            }
        }, "t32");
        t31.start();
        t32.start();
    }

    public static void main(String[] args) {
        Demo9 demo = new Demo9();
        demo.test();
    }
}

//运行结果：
//    t31 : cSyncA
//    t31 : cSyncA
//    t31 : cSyncA
//    t31 : cSyncA
//    t31 : cSyncA
//    t32 : cSyncB
//    t32 : cSyncB
//    t32 : cSyncB
//    t32 : cSyncB
//    t32 : cSyncB
//不能被同时访问。因为cSyncA()和cSyncB()都是static类型，x.cSyncA()相当于Something.isSyncA()，
//y.cSyncB()相当于Something.isSyncB()，因此它们共用一个同步锁，不能被同时反问。