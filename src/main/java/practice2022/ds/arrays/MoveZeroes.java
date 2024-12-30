package practice2022.ds.arrays;

import java.util.stream.IntStream;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums1 = {0,1,3,0,12};
        mz.moveZeroes(nums1);
        mz.printResult(nums1);
        int[] nums2 = {0};
        mz.moveZeroes(nums2);
        mz.printResult(nums2);


        int[] nums3 = {1,2,3,4,5};
        mz.moveZeroes(nums3);
        mz.printResult(nums3);

    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // int nonZeroPointer = -1;
        // for(int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         nums[++nonZeroPointer] = nums[i];
        //         if (i != nonZeroPointer) {
        //             nums[i] = 0;
        //         }
        //     }
        // }
        for (int i = 0, zeroPtr = 0; i < nums.length && zeroPtr < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroPtr];
                nums[zeroPtr++] = temp;
            }
        }

    }

    public void printResult(int[] result) {
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
