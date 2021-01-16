package java.mixed;

import java.util.Scanner;

/**
 * Created by gabor on 2019.04.27..
 */
public class SubArrrays {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        scan.close();

        int sumNeg = 0;

        for (int len = 1; len <= a.length; len++) {
            for (int i = 0; i <= a.length - len; i++) {
                System.out.printf("\n");
                int sumArray = 0;
                for (int j = i; j <= a.length - len; j++) {
                    System.out.printf("%d,", a[j]);
                    sumArray += a[j];
                }


                if (sumArray < 0) sumNeg++;
            }
        }

        System.out.printf("\n%d\n", sumNeg);

    }
}


