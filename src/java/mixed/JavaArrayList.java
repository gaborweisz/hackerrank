package java.mixed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gabor on 2019.04.27..
 */
public class JavaArrayList {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] row = scanner.nextLine().split("\\s");
        int n = Integer.parseInt(row[0]);

        List<List> mainArray = new ArrayList<>();
        List<String> resultArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split("\\s");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            List<Integer> subArray = new ArrayList<>();
            mainArray.add(subArray);

            for (int j = 1; j <= Integer.parseInt(arrRowItems[0]); j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                subArray.add(arrItem);
            }
        }

        row = scanner.nextLine().split("\\s");
        int q = Integer.parseInt(row[0]);

        for (int i = 0; i < q; i++) {

            String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int x = Integer.parseInt(arrRowItems[0])-1;
            int y = Integer.parseInt(arrRowItems[1])-1;

            if (x > mainArray.size()-1 || y > mainArray.get(x).size()-1) {
                resultArray.add("ERROR!");
            } else {
                resultArray.add(mainArray.get(x).get(y).toString());
            }
        }

        for (int i = 0; i < q; i++) {
            System.out.println(resultArray.get(i));
        }

        scanner.close();


    }
}
