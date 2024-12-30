package practice2022.ds.arrays;

import java.util.stream.IntStream;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        printResult(sortArrayByParity(nums));
        nums = new int[]{0};
        printResult(sortArrayByParity(nums));
    }

    private static int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
//            if (nums[start] % 2 != 0 && nums[end] % 2 == 0) {
//                int temp = nums[start];
//                nums[start++] = nums[end];
//                nums[end--] = temp;
//            } else if (nums[start] % 2 == 0) {
//                start++;
//            } else {
//                end--;
//            }
            // refactoring as we are decrementing end in two cases
            if (nums[start] % 2 == 0) {
                start++;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end--] = temp;
            }
        }
        return nums;
    }

    private static void printResult(int[] result) {
        IntStream.range(0, result.length)
                .forEach(i -> {
                    if (i == 0) {
                        System.out.print("[");
                    }
                    System.out.print(result[i]);
                    if (i < result.length - 1) {
                        System.out.print(",");
                    } else {
                        System.out.print("]");
                    }
                });
    }

}
