package java.mixed;

import java.util.*;

/**
 * Created by gabor on 2019.05.01..
 */
public class StackSolution {

    public static boolean isClosed(char a, char b) {
        return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
    }

    public static boolean isBalanced(String text) {

        if (text.isEmpty()) return true;
        if (text.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        int maxIter = stack.size() / 2;
        int iter = 0;
        while (stack.size() > 0 && iter < maxIter) {
            for (int i = 0; i < stack.size() - 1; i++) {
                char a = stack.get(i);
                char b = stack.get(i + 1);

                if (isClosed(a, b)) {
                    stack.remove(i);
                    stack.remove(i);
                }
            }
            iter++;
        }

        return stack.size() == 0;
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        List<String> inputList = new LinkedList<>();

        do {
            String input = sc.next();
            inputList.add(input);
        } while (sc.hasNext());

        sc.close();

        for (String s : inputList) {
            System.out.println(isBalanced(s));
        }

    }
}
