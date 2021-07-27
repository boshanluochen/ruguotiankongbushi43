package day4;

public class Demo5 {

    public synchronized void synMethod() {
        for (int i = 0; i < 1000000000; i++) {
            ;
        }
    }

    public void synBlock() {
        synchronized (this) {
            for (int i = 0; i < 100000000; i++) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        Demo5 demo = new Demo5();
        long start, diff;
        start = System.currentTimeMillis();
        demo.synMethod();
        diff = System.currentTimeMillis() - start;
        System.out.println("synMethod(): " + diff);
        start = System.currentTimeMillis();
        demo.synBlock();
        diff = System.currentTimeMillis() - start;
        System.out.println("synBlock(): " + diff);
    }

}
