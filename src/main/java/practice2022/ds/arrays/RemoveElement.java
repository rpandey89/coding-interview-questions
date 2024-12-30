package practice2022.ds.arrays;

import java.util.stream.IntStream;

class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};

        int k = removeElement(nums, 3);
        System.out.println(k);
        printArray(nums);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        k = removeElement(nums, 2);
        System.out.println(k);
        printArray(nums);

        nums = new int[]{1,1,1,1,1};
        k = removeElement(nums, 1);
        System.out.println(k);
        printArray(nums);

        nums = new int[]{2,2,3};
        k = removeElement(nums, 2);
        System.out.println(k);
        printArray(nums);



        nums = new int[]{1,2,3,4};
        k = removeElement(nums, 1);
        System.out.println(k);
        printArray(nums);

    }

    // copies elements equal to its own in place too
    public static int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;

    }

    // moves the val at the end
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = nums.length - 1;
        int start = 0;
        while (start <= k) {
            if (nums[start] == val) {
                nums[start] = nums[k];
                nums[k] = val;
                k--;
            } else {
                start++;
            }
        }
        return k+1;

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
