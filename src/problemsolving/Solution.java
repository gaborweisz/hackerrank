package problemsolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long[] arr = new long[n];
        long max = 0;

        //for (int[] q : queries) {
        //    for (int i = q[0]-1; i < q[1]; i++) {
        //        arr[i] += q[2];
        //    }
        //}

        int mini = Integer.MAX_VALUE;
        int maxi = 0;
        for (int[] q : queries) {
            if (mini > q[0] ) mini = q[0];
            if (maxi < q[1] ) maxi = q[1];
        }

        for (int i = mini-1; i<=maxi; i++) {
            for (int[] q : queries) {
                if (i>=q[0]-1 && i<q[1]) {
                    arr[i] += q[2];
                }

            }
        }

        for (long a : arr) {
            if (a > max) max = a;
        }

        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTUPT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

       System.out.println(result);

        scanner.close();
    }
}
