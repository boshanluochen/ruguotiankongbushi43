package Day7;

public class Demo1 {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
    }
}


//运行结果：
//    t1: 0
//    t1: 1
//    t1: 2
//    t1: 3
//    t1: 4
//    t1: 5
//    t1: 6
//    t1: 7
//    t1: 8
//    t1: 9
//结果说明：
//    程序比较简单，在主线程main中启动线程t1。t1启动之后，当t1中的计算i能被4整除时，t1会通过Thread.sleep(100)休眠100毫秒。