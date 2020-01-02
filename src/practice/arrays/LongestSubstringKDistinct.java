package practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/1/20
 */
public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: (Actual) " + findLength("araaci", 2) + " (Expected) 4");
        System.out.println("Length of the longest substring: (Actual) " + findLength("araaci", 1) + " (Expected) 2");
        System.out.println("Length of the longest substring: (Actual) " + findLength("cbbebi", 3) + " (Expected) 5");
    }

    /**
     * @param str input String
     * @param k   maximum number of distinct characters
     * @return maximum length of substring with k distinct characters
     */
    private static int findLength(String str, int k) {
        if (str == null || str.length() < 1 || k < 1) {
            return -1;
        }

        int start = 0, maxLength = Integer.MIN_VALUE;
        // character - frequency map
        Map<Character, Long> charSeenCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character currentChar = str.charAt(i);
            charSeenCount.put(currentChar, charSeenCount.getOrDefault(currentChar, 0L) + 1);
            // reduce the count of characters and subsequently size of the map till it is not <= k characters
            while (charSeenCount.size() > k) {
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
