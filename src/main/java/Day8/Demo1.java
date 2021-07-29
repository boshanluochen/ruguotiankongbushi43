package Day8;

public class Demo1 {

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s start\n", this.getName());
            for (int i = 0; i < 1000000; i++) {

            }
            System.out.printf("%s finish\n", this.getName());
        }
    }

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
        try {
            // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finish\n", Thread.currentThread().getName());
    }
}


//运行结果：
//    t1 start
//    t1 finish
//    main finish
//结果说明：
//    运行流程如图
//    (01) 在“主线程main”中通过 new ThreadA("t1") 新建“线程t1”。 接着，通过 t1.start() 启动“线程t1”，并执行t1.join()。
//    (02) 执行t1.join()之后，“主线程main”会进入“阻塞状态”等待t1运行结束。“子线程t1”结束之后，会唤醒“主线程main”，
//    “主线程”重新获取cpu执行权，继续运行。
