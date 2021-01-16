package java.mixed;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gabor on 2019.04.26..
 */
public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String[] tokenArray = s.split("[ !,?._'@]");
        Stream<String> stream = Arrays.stream(tokenArray);
        List<String> tokens = stream.filter(t -> t.length() > 0).collect(Collectors.toList());
        System.out.println(tokens.size());
        tokens.stream().forEach(System.out::println);

        scan.close();
    }
}
