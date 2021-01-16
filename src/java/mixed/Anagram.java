package java.mixed;

import java.util.Scanner;

/**
 * Created by gabor on 2019.04.26..
 */
public class Anagram {

    static boolean isAnagram(String a, String b) {
        String la = a.toLowerCase();
        String lb = b.toLowerCase();
        StringBuffer buffer = new StringBuffer(lb);

        if (la.length() != lb.length()) return  false;

        int counter = la.length();
        for (Character c :  la.toCharArray()) {
            if (lb.contains(c.toString())) {
                lb = buffer.deleteCharAt(buffer.indexOf(c.toString())).toString();
                counter--;
            }
        }

        return counter == 0;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
