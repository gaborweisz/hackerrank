package concurrency;

/**
 * Created by gabor on 2019.06.28..
 */
public class LongCalcRunnable implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("Helloo Runable : " + Thread.currentThread().getId());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
