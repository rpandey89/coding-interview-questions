package practice2024;

import java.util.stream.IntStream;
import java.util.stream.Collectors;
/**
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortByParity {

    public int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            if(nums[start] % 2 != 0 && nums[end] % 2 == 0) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }

            if (nums[start] % 2 == 0) {
                start++;
            }

            if (nums[end] % 2 != 0) {
                end--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortByParity sbp = new SortByParity();
        int[] nums1 = sbp.sortArrayByParity(new int[]{3,1,2,4});
        System.out.println(IntStream.of(nums1).boxed().collect(Collectors.toList()));

        int[] nums2 = sbp.sortArrayByParity(new int[]{0});
        System.out.println(IntStream.of(nums2).boxed().collect(Collectors.toList()));
    }

}
