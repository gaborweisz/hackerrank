package concurrency;

/**
 * Created by gabor on 2019.06.28..
 */
public class SimpleThread {

    public static void main(String[] args) {
        LongCalcRunnable c = new LongCalcRunnable();
        LongCalcThread thread1 = new LongCalcThread();
        Thread thread2 = new Thread(c);

        thread1.start();
        thread2.start();
    }



}
