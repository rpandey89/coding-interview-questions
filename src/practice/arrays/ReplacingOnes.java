package practice.arrays;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 1/9/20
 */
public class ReplacingOnes {

    public static void main(String[] args) {
        System.out.println("(Actual) " + ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2) + " (Expected) 6");
        System.out.println("(Actual) " + ReplacingOnes.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3) + " (Expected) 9");
    }

    /**
     * Time Complexity O(n) Space Complexity O(1)
     *
     * @param arr input array with 0s and 1s
     * @param k   maximum number of 0s that can be replaced
     * @return length of longest sub-array which will have max 1s after replacing k 0s
     */
    private static int findLength(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k < 1) {
            return -1;
        }

        int start = 0, maxLength = Integer.MIN_VALUE, maxOneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                maxOneCount++;
            }
            // we will need to figure out how many zeros are present between i and start
            // and moving start index to right till the difference between total number of digits and current one count is greater than k
            // decrease the 1's count as well if the element at start index is 1
            while (i - start + 1 - maxOneCount > k) {
                if (arr[start] == 1) {
                    maxOneCount--;
                }
                start++;
            }
            maxLength = Integer.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
