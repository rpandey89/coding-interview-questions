package practice2022.algo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums1 = {1,2,3,4,5,6,7};
        int k = 3;
        ra.rotate(nums1, k);
        ra.printResult(nums1);
        int[] nums2 = {-1, -99, 22, 100};
        k = 2;
        ra.rotate(nums2, k);
        ra.printResult(nums2);

        int[] nums3 = {-1};
        k = 2;

        ra.rotate(nums3, k);
        ra.printResult(nums3);
    }

    public void rotate(int[] nums, int k) {
        // in case k is larger than array length
        k = k % nums.length;
        // reverse whole array
        reverse(nums, 0, nums.length - 1);
        // reverse parts of the array
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // reverse array
    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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
