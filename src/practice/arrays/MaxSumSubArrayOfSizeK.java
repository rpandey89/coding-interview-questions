package practice.arrays;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 12/26/19
 */
public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] input = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaxSumSubArrayOfSizeK(input, k) == 9);
        input = new int[]{2, 3, 4, 1, 5};
        k = 2;
        System.out.println(findMaxSumSubArrayOfSizeK(input, k) == 7);
    }

    /**
     * Time Complexity O(n) Space Complexity O(1)
     * no. of contiguous arrays = length - K + 1
     * 9 - 5 + 1 = 5
     *
     * @param input array of elements
     * @param k     number of elements in the sub array
     * @return max sum of contiguous set elements sub-array
     */
    private static int findMaxSumSubArrayOfSizeK(int[] input, int k) {
        if (input == null || input.length < 1 || k < 1) {
            return -1;
        }
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - input[i - k + 1];
            }
        }
        return maxSum;
    }
}
