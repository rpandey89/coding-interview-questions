package practice2022.ds.arrays;

import java.util.stream.IntStream;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class FindDisappearingNums {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        printArray(nums);
        System.out.println(findDisappearedNumbers(nums));

        nums = new int[]{1,1};
        printArray(nums);
        System.out.println(findDisappearedNumbers(nums));

    }

    // Time O(n)
    // Space O(1)
    // Using the property of array that an element num between 1 and n will be at index num - 1 in the array
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numsNotSeen = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // make sure to take absolute of the value at the index as we are updating the magnitude of the values
            int position = Math.abs(nums[i]) - 1;
            if (nums[position] > 0) {
                nums[position] *= -1;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                numsNotSeen.add(i+1);
            }
        }

        return numsNotSeen;

    }

    // Time: O(n)
    // Space: O(n)
    // This takes additional space
    private static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> numsNotSeen = new ArrayList<>();
        Set<Integer> numsSeen = new HashSet<>();
        for(int num: nums) {
            numsSeen.add(num);
        }

        for(int i = 1; i <= nums.length; i++) {
            if (!numsSeen.contains(i)) {
                numsNotSeen.add(i);
            }
        }

        return numsNotSeen;

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
