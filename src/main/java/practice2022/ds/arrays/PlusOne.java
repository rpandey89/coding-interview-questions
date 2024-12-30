package practice2022.ds.arrays;

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;


class PlusOne {

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        printArray(nums);
        printArray(plusOne(nums));

        nums = new int[]{1,2,3};
        printArray(nums);
        printArray(plusOne(nums));


        nums = new int[]{2, 1, 1};
        printArray(nums);
        printArray(plusOne(nums));


        nums = new int[]{9, 9, 9};
        printArray(nums);
        printArray(plusOne(nums));


    }

    private static int[] plusOne(int[] digits) {
        int[] digitsSum = new int[digits.length];
        int increment = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + increment;
            if (sum == 10) {
                sum = 0;
                increment = 1;
            } else {
                increment = 0;
            }
            digitsSum[i] = sum;
        }
        if (increment == 1) {
            int[] result = new int[digits.length + 1];
            int index = 1;
            for (int i = 0; i < digits.length; i++) {
                result[index] = digitsSum[i];
            }
            result[0] = 1;
            return result;
        }
        return digitsSum;

        // Collections.revers(digitsSum);
        // digitsSum.stream().mapToInt(i -> i).toArray();
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
