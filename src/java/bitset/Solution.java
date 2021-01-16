package java.bitset;

import java.util.*;

public class Solution {

    public static String apply(String operation, int n1, int n2, BitSet B1, BitSet B2) {
        if ("AND".equals(operation)) {
            if (n1 == 1) B1.and(B2);
            else B2.and(B1);
        }
        if ("OR".equals(operation)) {
            if (n1 == 1) B1.or(B2);
            else B2.or(B1);
        }
        if ("XOR".equals(operation)) {
            if (n1 == 1) B1.xor(B2);
            else B2.xor(B1);
        }
        if ("FLIP".equals(operation)) {
            if (n1 == 1) B1.flip(n2);
            else B2.flip(n2);
        }
        if ("SET".equals(operation)) {
            if (n1 == 1) B1.set(n2);
            else B2.set(n2);
        }

        return B1.cardinality() + " " +B2.cardinality();




    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        BitSet B1 = new BitSet(n);
        BitSet B2 = new BitSet(n);

        List<String> result = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String op = in.next();
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            result.add(apply(op, n1, n2, B1, B2));
        }

        result.forEach(System.out::println);

    }
}
