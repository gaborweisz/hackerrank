package cloudera_coding_challenge;

import java.util.*;

class Result {

    /*
     * Complete the 'usernamesSystem' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY u as parameter.
     */
    public static void main(String[] args) {

        List<Integer> li = new LinkedList<>() ;

        li.add(1);
        li.add(1);
        li.add(1);
        li.add(1);

        System.out.println(deleteProducts(li, 2));


    }

    public static int deleteProducts(List<Integer> ids, int m) {
        Map<Integer, Integer> idCounter = new HashMap<>();

        for (Integer id : ids) {
            Integer count = idCounter.get(id);

            if (count == null) {
                idCounter.put(id, 1);
            } else {
                idCounter.put(id, ++count);
            }
        }

        List<Integer> countList = new ArrayList<>(idCounter.values());

        Collections.sort(countList);

        int countOfDistinctElements = countList.size();
        int sumOfRemove = 0;
        int maxRemove = m;

        for (int count : countList) {
            maxRemove -= count;

            if (maxRemove >= 0) {
                sumOfRemove++;
            } else {
                break;
            }

        }

        return countOfDistinctElements - sumOfRemove;

    }


    public static List<String> usernamesSystem(List<String> u) {

        Map<String, Integer> nameCounter = new HashMap<>();
        List<String> userNames = new LinkedList<>();

        for (String name : u) {
            Integer count = nameCounter.get(name);
            if (count == null) {
                userNames.add(name);
                nameCounter.put(name, 1);
            } else {
                userNames.add(name.concat(count.toString()));
                nameCounter.put(name, ++count);
            }
        }

        return userNames;

    }


}