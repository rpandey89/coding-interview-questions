package practice2022.ds.arrays;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] nums1 = {3,2,4};
        int[] nums2 = {3,3};

        TwoSum ts = new TwoSum();
        ts.printResult(ts.twoSum(nums, 9));
        ts.printResult(ts.twoSum(nums1, 6));
        ts.printResult(ts.twoSum(nums2, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> numIndices = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numIndices.containsKey(diff)) {
                return new int[]{numIndices.get(diff), i};
            }
            numIndices.put(nums[i], i);
        }
        return null;
    }

    public void printResult(int[] result) {
        IntStream.range(0, result.length).forEach(i -> {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(",");
            }
            if (i == result.length - 1) {
                System.out.println("]");
            }
        });
    }
}