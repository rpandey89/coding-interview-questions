package practice2022.ds.arrays;

import java.util.stream.IntStream;

class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        printArray(nums);
        System.out.println(pivotIndex(nums));

        nums = new int[]{1, 2, 3};
        printArray(nums);
        System.out.println(pivotIndex(nums));


        nums = new int[]{2, 1, -1};
        printArray(nums);
        System.out.println(pivotIndex(nums));


        nums = new int[]{0, 2, 0};
        printArray(nums);
        System.out.println(pivotIndex(nums));


        nums = new int[]{2, 2, 2, 2, 2};
        printArray(nums);
        System.out.println(pivotIndex(nums));


    }

    // Contains two solutions
    // One uses O(N) extra space with time O(N)
    // Second uses O(1) with time O(N)
    private static int pivotIndex(int[] nums) {
//        int[] sums = new int[nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//
//        int pivotIndex = -1;
//        int totalSum = sums[nums.length - 1] + nums[nums.length - 1];
//        for (int i = 0; i < nums.length; i++) {
//            if (sums[i] == (totalSum - nums[i] - sums[i])) {
//                pivotIndex = i;
//                break;
//            }
//        }
//
//        return pivotIndex;
        int leftSum = 0;
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum += nums[i - 1];
            }

            if (leftSum == (totalSum - nums[i] - leftSum)) {
                return i;
            }
        }
        return -1;

    }

    private static void printArray(int[] nums) {
        IntStream
            .range(0, nums.length)
            .forEach(i -> {
                if (i == 0) {
                    System.out.print("[ ");
                }
                System.out.print(nums[i]);
                if (i < nums.length - 1) {
                    System.out.print(", ");
                } else {
                    System.out.print("]\n");
                }

            });

    }


}