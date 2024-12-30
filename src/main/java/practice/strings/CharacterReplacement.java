package practice.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/1/20
 */
public class CharacterReplacement {

    public static void main(String[] args) {
        System.out.println("(Actual) " + findLength("aabccbb", 2) + " (Expected) 5");
        System.out.println("(Actual) " +findLength("abbcb", 1) + " (Expected) 4");
        System.out.println("(Actual) " +findLength("abccde", 1)+ " (Expected) 3");
    }

    /**
     * Time Complexity O(n) Space Complexity O(K)
     *
     *
     * @param str input string
     * @param k number of characters that could be replaced
     * @return longest substring with repeated characters after replacement
     */
    private static int findLength(String str, int k) {
        if (str == null || str.length() < 1 || k < 1) {
            return -1;
        }

        int start = 0, maxLength = Integer.MIN_VALUE, maxRepeatedCharCount = Integer.MIN_VALUE;
        // character - frequency map
        Map<Character, Integer> charSeenCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character currentChar = str.charAt(i);
            charSeenCount.put(currentChar, charSeenCount.getOrDefault(currentChar, 0) + 1);
            maxRepeatedCharCount = Math.max(maxRepeatedCharCount, charSeenCount.get(currentChar));
            // reduce the count of characters and subsequently size of the map
            // such that at any given point of time there is only one character that is repeated maxRepeatedCharCount times
            // and only k characters with one occurrence as they will be replaced with the repeated character
            while (i - start + 1 - maxRepeatedCharCount > k) {
                Character startChar = str.charAt(start);
                charSeenCount.put(startChar, charSeenCount.get(startChar) - 1);
                if (charSeenCount.get(startChar) == 0) {
                    charSeenCount.remove(startChar);
                }
                start++; // go to next character from start
            }
            // i - start + 1 i.e. number of characters between now and start of the substring
            maxLength = Math.max(maxLength, i - start + 1); // calculate max length till now
        }
        return maxLength;
    }
}

