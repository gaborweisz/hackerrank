package java.mixed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by gabor on 2019.04.26..
 */
public class PatternSyntaxChecker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<String> results = new ArrayList<>();
        while(testCases>0){
            String pattern = in.nextLine();

            try {
                Pattern.compile(pattern);
                results.add("Valid");
            } catch (PatternSyntaxException e) {
                results.add("Invalid");
            }

            testCases--;
        }

        results.stream().forEach(System.out::println);
    }
}
