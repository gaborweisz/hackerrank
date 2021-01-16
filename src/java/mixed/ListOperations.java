package java.mixed;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gabor on 2019.05.01..
 */
public class ListOperations {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<Integer> L = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            L.add(scan.nextInt());
        }

        int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            String op = scan.next();

            if ("Insert".equals(op)) {
                int index = scan.nextInt();
                int number = scan.nextInt();
                L.add(index, number);
            }
            if ("Delete".equals(op)) {
                int index = scan.nextInt();
                L.remove(index);
            }
        }

        scan.close();

        L.forEach(e -> System.out.printf("%d ", e));
    }
}
