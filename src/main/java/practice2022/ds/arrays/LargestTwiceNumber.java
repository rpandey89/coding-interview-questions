package practice2022.ds.arrays;

import java.util.stream.IntStream;

public class LargestTwiceNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        printArray(nums);
        System.out.println(dominantIndex(nums));

        nums = new int[]{1,2,3};
        printArray(nums);
        System.out.println(dominantIndex(nums));


        nums = new int[]{2, 1, -1};
        printArray(nums);
        System.out.println(dominantIndex(nums));

        nums = new int[]{3, 6, 1, 0};
        printArray(nums);
        System.out.println(dominantIndex(nums));

        nums = new int[]{1};
        printArray(nums);
        System.out.println(dominantIndex(nums));

    }

    private static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int largest = -1;
        int secondLargest = -1;
        for(int i = 0; i < nums.length; i++) {
            if (largest == -1 || nums[i] > nums[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (secondLargest == -1 || (nums[i] < nums[largest] && nums[i] > nums[secondLargest])) {
                secondLargest = i;
            }
        }

        return nums[largest] >= 2 * nums[secondLargest] ? largest : -1;
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
