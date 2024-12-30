package practice.arrays;


/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 12/27/19
 */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] input = {2, 1, 5, 2, 3, 2};
        int S = 7;
        //System.out.println(findMinSubArraySizeBrute(input, S) == 2);
        System.out.println(findMinSubArraySize(input, S) == 2);
        input = new int[]{2, 1, 5, 2, 8};
        //System.out.println(findMinSubArraySizeBrute(input, S) == 1);
        System.out.println(findMinSubArraySize(input, S) == 1);
        input = new int[]{3, 4, 1, 1, 6};
        S = 8;
        //System.out.println(findMinSubArraySizeBrute(input, S) == 3);
        System.out.println(findMinSubArraySize(input, S) == 3);
    }

    /**
     * Time complexity O(n^2) Space complexity O(n)
     *
     * @param input array of elements
     * @param S     target sum
     * @return minimum number of contiguous elements sub-array that sum up equal or greater than S
     */
    private static int findMinSubArraySizeBrute(int[] input, int S) {
        if (input == null || input.length < 1) {
            return -1;
        }
        int minSubArrLength = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            int sum = 0, cnt = 1;
            for (int j = i; j < input.length; j++) {
                sum = sum + input[j];
                if (sum >= S) {
                    minSubArrLength = Math.min(minSubArrLength, cnt);
                    break;
                }
                cnt++;
            }
        }
        return minSubArrLength;
    }

    /**
     * Time Complexity O(n) Space Complexity O(1)
     * Each element will be visited atmost twice so O(2n) ~= O(n)
     *
     * @param input array of elements
     * @param S     target sum
     * @return minimum number of contiguous elements sub-array that sum up equal or greater than S
     */
    private static int findMinSubArraySize(int[] input, int S) {
        if (input == null || input.length < 1) {
            return -1;
        }
        int minSubArrLength = Integer.MAX_VALUE, start = 0, sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
            while (sum >= S) {
                // check the minimum length and then subtract the start
                minSubArrLength = Math.min(minSubArrLength, i - start + 1);
                sum = sum - input[start];
                start++;
            }
        }
        return minSubArrLength;
    }
}
