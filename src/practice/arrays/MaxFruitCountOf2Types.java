package practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/5/20
 */
public class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: (Actual) " +
                findLength(new char[]{'A', 'B', 'C', 'A', 'C'}) + " (Expected) 3");
        System.out.println("Maximum number of fruits: (Actual) " +
                findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}) + " (Expected) 5");
    }

    public static int findLength(char[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int start = 0, maxLength = Integer.MIN_VALUE;
        // character - frequency map
        Map<Character, Long> charSeenCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Character currentChar = arr[i];
            charSeenCount.put(currentChar, charSeenCount.getOrDefault(currentChar, 0L) + 1);
            // reduce the count of characters and subsequently size of the map till it is not <= k characters
            while (charSeenCount.size() > 2) {
                Character startChar = arr[start];
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
