package practice.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/14/20
 */
public class StringPermutation {

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc") + " (Expected): true");
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc") + " (Expected): false");
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx") + " (Expected): true");
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc") + " (Expected): true");
    }

    /**
     * Time Complexity O(N + M) Space Complexity O(M)
     * M is number of characters in the pattern
     *
     * @param str     input string
     * @param pattern pattern to be tested for permutation
     * @return true if input string contains a permutation of pattern
     */
    private static boolean findPermutation(String str, String pattern) {
        if (str == null || str.isEmpty() || pattern == null || pattern.isEmpty()) {
            return false;
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
            if (matchedChars == charSeenCount.size()) {
                return true;
            }
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
        }
        return matchedChars == charSeenCount.size();
    }
}
