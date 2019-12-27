package practice.arrays;

import java.util.Arrays;

/**
 * @author rpandey
 * @implNote Sliding Window Algorithm Problem
 * @since 12/26/19
 */
public class AverageOfSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 6, -1, 4, 1, 8, 2, 5};
        int k = 5;
        //double[] result = findSubArrayAverages(input, k);
        double[] result = findSubArrayAveragesBrute(input, k);
        Arrays.stream(result).forEach(System.out::println);
    }

    /**
     * Time Complexity O(nk) Space Complexity O(i-k+1)
     * no. of contiguous arrays = length - K + 1
     * 9 - 5 + 1 = 5
     * @param input array of elements
     * @param k number of elements in the sub array
     * @return array of averages of contiguous sub-arrays of size k
     */
    private static double[] findSubArrayAveragesBrute(int[] input, int k) {
        if (input == null || input.length < 1) {
            return new double[0];
        }

        double[] result = new double[input.length - k + 1];
        for (int i = 0; i < input.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j <= i + k - 1; j++) {
                sum += input[j];
            }
            result[i] = sum / (double) k;
        }
        return result;
    }

    /**
     * Time Complexity O(n) Space Complexity O(n - k + 1)
     * no. of contiguous arrays = length - K + 1
     * 9 - 5 + 1 = 5
     * @param input array of elements
     * @param k number of elements in the sub array
     * @return array of averages of contiguous sub-arrays of size k
     */
    private static double[] findSubArrayAverages(int[] input, int k) {
        if (input == null || input.length < 1) {
            return new double[0];
        }

        // no of contiguous arrays = length - K + 1
        // 9 - 5 + 1 = 5
        double[] result = new double[input.length - k + 1];
        int sum = 0;//, resultIndex = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (i >= k - 1) {
                result[i - k + 1] = sum / (double) k;
                sum -= input[i - k + 1];
                // resultIndex == i - k + 1
                //resultIndex++;
            }
        }
        return result;
    }
}
