package practice2022.ds.arrays;

import java.util.stream.IntStream;

class ElementWithGreaterRightNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{400};
        printArray(replaceElements(nums));

        nums = new int[]{17, 18, 5, 4, 6, 1};
        printArray(replaceElements(nums));

    }

    public static int[] replaceElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int previous = nums[nums.length - 1];
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                nums[i] = -1;
            } else {
                max = Math.max(previous, max);
                previous = nums[i];
                nums[i] = max;
            }
        }

        return nums;

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
                    System.out.print(" ]\n");
                }
            });

    }


}
