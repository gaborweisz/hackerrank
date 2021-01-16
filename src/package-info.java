import java.util.Arrays;

class Main {
    public static void main(String[] a) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        int A1[] = {-1, -3};
        int A2[] = {1, 3, 6, 4, 1, 2, 6, 6, 6, 6,-7,-9,-1225,12345};
        int A3[] = {1, 2, 3};

        System.out.println("solution = " + solution.solution(A1));
        System.out.println("solution = " + solution2.solution(A1));
        System.out.println("solution = " + solution.solution(A2));
        System.out.println("solution = " + solution2.solution(A2));
        System.out.println("solution = " + solution.solution(A3));
        System.out.println("solution = " + solution2.solution(A3));
    }
}


class Solution {

    public int solution(int[] A) {
        int expected_number = 1;

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] == expected_number) {
                expected_number = A[i] + 1;

            }
        }

        return expected_number;
    }
}

class Solution2 {
    public int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length == 0) return 1; //edge case

        int result = 0;
        for (int n = 1; n <= 100000; n++) {
            int i = 0;
            while (i < A.length && A[i] != n) {
                i++;
            }

            if (i == A.length) {
                result = n;
                break;
            }
        }

        return result;
    }
}