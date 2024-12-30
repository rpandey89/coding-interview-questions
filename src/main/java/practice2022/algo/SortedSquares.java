package practice2022.algo;

import java.util.stream.IntStream;

public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares ssq = new SortedSquares();
        int[] nums1 = {-4, -1, 0, 3, 10};
        ssq.printResult(ssq.sortedSquares(nums1));
        int[] nums2 = {-7,-3,2,3,11};
        ssq.printResult(ssq.sortedSquares(nums2));

    }

    // Two pointer approach works over here to sort array because one half has all -ve numbers in decreasing order and other half has positive numbers in decreasing order
    // so mainly we compare the numbers at two pointers using absolute values
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int k = j;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    // looks cleaner
    public int[] sortedSquares2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int j = end;
        while (start <= end) {
            int sqStart = nums[start] * nums[start];
            int sqEnd = nums[end] * nums[end];
            if (sqStart >= sqEnd) {
                result[j] = sqStart;
                start++;
            } else {
                result[j] = sqEnd;
                end--;
            }
            j--;
        }
        return result;
    }


    public void printResult(int[] result) {
        IntStream.range(0, result.length).forEach(i -> {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(",");
            }
            if (i == result.length - 1) {
                System.out.println("]");
            }
        });
    }
}