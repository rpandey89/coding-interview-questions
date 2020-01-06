package practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/1/20
 */
public class NoRepeatSubstring {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: (Actual) " + findLength("aabccbb") + " (Expected) 3");
        System.out.println("Length of the longest substring: (Actual) " + findLength("abbbb") + " (Expected) 2");
        System.out.println("Length of the longest substring: (Actual) " + findLength("abccde") + " (Expected) 3");
    }

    /**
     * Time Complexity O(n) Space Complexity O(K) where K <= n
     * Taking into consideration the english alphabet that has 26 chars
     * there will be constant space of O(1)
     *
     * @param str input string
     * @return length of the longest substring with no repeating characters
     */
    private static int findLength(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        // character - last index seen map
        Map<Character, Integer> charIndexSeen = new HashMap<>();
        // start of the window
        int start = 0, maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Character current = str.charAt(i);
            // if the map already contains the current character
            // then it means that we need to shift the start of the window to the right
            if (charIndexSeen.containsKey(current)) {
                start = charIndexSeen.get(current) + 1;
            }
            // put the char in the map
            charIndexSeen.put(current, i);
            // calculate the length of the current substring
            // and check whether that is the max
            maxLength = Integer.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
