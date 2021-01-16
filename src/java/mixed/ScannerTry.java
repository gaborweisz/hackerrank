package java.mixed;


import java.util.*;

/**
 * Created by gabor on 2019.05.01..
 */
public class ScannerTry {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int line = 0;
        do {
            System.out.println(++line + " " + sc.nextLine());
        } while (sc.hasNext());
    }


}
