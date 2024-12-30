package practice2022.ds.arrays;

import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class FindThirdHighestNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        printArray(nums);
        System.out.println(thirdMax(nums));

        nums = new int[]{3, 2, 1};
        printArray(nums);
        System.out.println(thirdMax(nums));


        nums = new int[]{3, 2};
        printArray(nums);
        System.out.println(thirdMax(nums));

    }

    private static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num != first) { // num should be < first and > second
                third = second;
                second = num;
            } else if (num > third && num != first && num != second) { // num should be < second and gt third
                third = num;
            }
        }

        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }


    // This unnecessarily takes time to get the length of set, remove element from set
    // for just 3 elements
    private static int thirdMax1(int[] nums) {
        List<Integer> maxElements = new ArrayList<>();
        for(int num : nums) {
            maxElements.add(num);

            if (maxElements.size() > 3) {
                maxElements.remove(Collections.min(maxElements));
            }
        }

        return maxElements.size() == 3 ? Collections.min(maxElements) : Collections.max(maxElements);

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