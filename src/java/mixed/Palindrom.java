package java.mixed;

import java.util.Scanner;

/**
 * Created by gabor on 2019.04.26..
 */
public class Palindrom {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        if (A.equals(reverse(A))) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }

    private static  String reverse(String text) {
        StringBuffer rev = new StringBuffer(text);

        return rev.reverse().toString();
    }
}
