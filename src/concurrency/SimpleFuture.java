package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by gabor on 2019.06.28..
 */
public class SimpleFuture {

    public static void main(String[] args) {
        Future<Integer> future = new SquareCalculator().calculate(10);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Integer result = future.get();

            System.out.println("Result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
