package practice2022.ds.arrays;

import java.util.stream.IntStream;

class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {2,2,3,3};
        int k = removeDuplicates(nums);
        System.out.println(k);
        printArray(nums);

        nums = new int[]{0, 0, 1, 2, 2, 3, 4, 4, 4};
        k = removeDuplicates(nums);
        System.out.println(k);
        printArray(nums);

        nums = new int[]{1,1,1,1,1};
        k = removeDuplicates(nums);
        System.out.println(k);
        printArray(nums);

        nums = new int[]{2,2,3};
        k = removeDuplicates(nums);
        System.out.println(k);
        printArray(nums);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;

    }

    private static void printArray(int[] nums) {
        IntStream
                .range(0, nums.length)
                .forEach(i -> {
                    if (i == 0) {
                        System.out.print("[ ");
                    }
                    System.out.print(nums[i]);
                    if (i == nums.length - 1) {
                        System.out.print(" ]\n");
                    } else {
                        System.out.print(", ");
                    }
                });
    }


}