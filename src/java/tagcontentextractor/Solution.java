package java.tagcontentextractor;


import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<String> results = new ArrayList<>();

        while (testCases > 0) {
            String line = in.nextLine();

            Set<String> tags = findTags(line);
            Stream<String> stream = Arrays.stream(line.split("<|>|><"));
            List<String> s = stream.filter(e -> !"".equals(e)).collect(Collectors.toList());

            int contentFound = 0;
            for (int i = 0; i < s.size() - 2; i++) {

                String firstPart = s.get(i);
                String middlePart = s.get(i + 1);
                String thirdPart = s.get(i + 2);

                if (firstPart.length() == 0) continue;

                if (isOpeningTag(firstPart, tags) && isContent(middlePart, tags) && isClosingTag(thirdPart, tags) && isMatchingTags(firstPart, thirdPart)) {
                    results.add(middlePart);
                    contentFound++;
                }
            }

            if (contentFound == 0) results.add("None");

            testCases--;
        }

        results.stream().forEach(System.out::println);
    }

    static Set<String> findTags(String s) {
        Pattern pattern = Pattern.compile("<[^>]+>|\\+");
        Matcher matcher = pattern.matcher(s);
        Set<String> tags = new HashSet<>();

        while (matcher.find()) {
            tags.add(matcher.group());
        }

        return tags;
    }


    static boolean isTag(String s, Set<String> tags) {
        return tags.contains("<" + s + ">");
    }

    static boolean isClosingTag(String s, Set<String> tags) {
        return isTag(s, tags) && "/".equals(s.substring(0, 1));
    }

    static boolean isOpeningTag(String s, Set<String> tags) {
        return isTag(s, tags) && !isClosingTag(s, tags);
    }

    static boolean isContent(String s, Set<String> tags) {
        return !isTag(s, tags) && !isClosingTag(s, tags);
    }

    static boolean isMatchingTags(String openTag, String closingTag) {
        return openTag.substring(0, openTag.length()).equals(closingTag.substring(1, closingTag.length()));
    }

}
