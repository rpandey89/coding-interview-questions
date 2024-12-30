package practice2022.ds.arrays;

import java.util.Set;
import java.util.HashSet;

public class DuplicateElementsInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        DuplicateElementsInArray deia = new DuplicateElementsInArray();
        System.out.println(deia.containsDuplicate(nums));

        int[] nums1 = {1,2,3,4};
        System.out.println(deia.containsDuplicate(nums1));

        int[] nums2 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(deia.containsDuplicate(nums2));

    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> unique = new HashSet<>();
        for (int num: nums) {
//            if (unique.contains(num)) {
//                return true;
//            }
//            unique.add(num);
            // can just directly check with add method
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }
}
