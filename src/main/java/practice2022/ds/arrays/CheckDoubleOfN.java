package practice2022.ds.arrays;

import java.util.stream.IntStream;
import java.util.Set;
import java.util.HashSet;

public class CheckDoubleOfN {

    public static void main(String[] args) {
        int[] nums = {10,2,5,3};
        printArray(nums);
        System.out.println(checkIfExist(nums));


        nums = new int[]{7,1,14,11};
        printArray(nums);
        System.out.println(checkIfExist(nums));

        nums = new int[]{3,1,7,11};
        printArray(nums);
        System.out.println(checkIfExist(nums));

    }

    public static boolean checkIfExist(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> elements = new HashSet<>();

        for (int num : nums) {
            int twice = num * 2;
            int half = num / 2;
            if (elements.contains(twice) || (num % 2 == 0 && elements.contains(half))) {
                return true;
            }
            elements.add(num);
        }

        return false;

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
