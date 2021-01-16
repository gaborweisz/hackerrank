package java.javadequeue;

import java.util.*;

class Solution {

    Set<Integer> loadElements(Deque<Integer> deque) {
        Iterator<Integer> iterator = deque.iterator();
        Set<Integer> counter = new HashSet<>();

        while (iterator.hasNext()) {
            Integer n = iterator.next();
            counter.add(n);
        }

        return counter;
    }

    int solveIt(Deque<Integer> deque, Deque<Integer> subQueue) {

        Set<Integer> counter = loadElements(subQueue);
        int maxUniueNumbers = counter.size();

        do {

            if (!deque.isEmpty()) {
                Integer n = deque.pop();
                subQueue.addLast(n);
                counter.add(n);
            }

            Integer n = subQueue.pop();
            if (!subQueue.contains(n))
                counter.remove(n);

            maxUniueNumbers = maxUniueNumbers < counter.size() ? counter.size() : maxUniueNumbers;
        } while (deque.size() > 0);

        return maxUniueNumbers;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> subQueue = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            subQueue.add(num);
        }

        for (int i = 0; i < n - m; i++) {
            int num = in.nextInt();
            deque.add(num);
        }


        Solution s = new Solution();
        System.out.println(s.solveIt(deque, subQueue));

    }
}
