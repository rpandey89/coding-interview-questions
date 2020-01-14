package practice.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/14/20
 */
public class StringAnagrams {

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq")+ " (Expected): [1, 2]");
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc") + " (Expected): [2, 3, 4]");
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        if (str == null || str.isEmpty() || pattern == null || pattern.isEmpty()) {
            return resultIndices;
        }

        // put all the characters in the map
        Map<Character, Integer> charSeenCount = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char current = pattern.charAt(i);
            charSeenCount.put(current, charSeenCount.getOrDefault(current, 0) + 1);
        }

        // window start
        // number matched characters at a time
        int start = 0, matchedChars = 0;
        for (int i = 0; i < str.length(); i++) {
            // get the character and check whether that exists in the seen characters map
            char current = str.charAt(i);
            if (charSeenCount.containsKey(current)) {
                // decrement the count
                // and the count is zero that means we should have iterated all the characters for the permutation
                // so increment the number of matched chars
                charSeenCount.put(current, charSeenCount.get(current) - 1);
                if (charSeenCount.get(current) == 0) {
                    matchedChars++;
                }
            }

            // shrink the window if the number of characters are more than the characters in the pattern
            if (i - start + 1 > pattern.length()) {
                char startChar = str.charAt(start);
                if (charSeenCount.containsKey(startChar)) {
                    // decrement the matchedChars and then increment the count on the seen map
                    int currentCount = charSeenCount.get(startChar);
                    if (currentCount == 0) {
                        matchedChars--;
                    }
                    charSeenCount.put(startChar, currentCount + 1);
                }
                start++;
            }
            if (matchedChars == charSeenCount.size()) {
                resultIndices.add(start);
            }
        }
        return resultIndices;
    }
}
