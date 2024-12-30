package practice2024;

import java.util.Set;
import java.util.HashSet;
import java.util.BitSet;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-common-elements-between-two-arrays/description/
 */
public class CommonElement2Arrays {

	public int[] findIntersectionValues(int[] nums1, int[] nums2) {
		//Set<Integer> numSet1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());

        Set<Integer> numSet1 = new HashSet<>();
        for (int el: nums1) {
            numSet1.add(el);
        }
        int[] bits = new int[101];
        for (int el: nums1) {
            bits[el] = 1;
        }

        //Set<Integer> numSet2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> numSet2 = new HashSet<>();
        for (int el: nums2) {
            numSet2.add(el);
        }
        int[] bits1 = new int[101];
        for (int el: nums2) {
            bits1[el] = 1;
        }

        int[] result = new int[2];
        int[] result1 = new int[2];
        for (int el: nums1) {
        	if(numSet2.contains(el)) {
        		result[0] = result[0] + 1;
        	}
            result1[0] = result1[0] + bits1[el];
        }

        for (int el: nums2) {
        	if(numSet1.contains(el)) {
        		result[1] = result[1] + 1;
        	}
            result1[1] = result1[1] + bits[el];
        }
        return result1;
    }

	public static void main(String[] args) {
		CommonElement2Arrays ce2A = new CommonElement2Arrays();
		// int[] result = ce2A.findIntersectionValues(new int[]{4,3,2,3,1}, new int[]{2,2,5,2,3,6});
		// System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));

        int[] result = ce2A.findIntersectionValues(new int[]{39,78,49,12,57,47,80,92,29,59,49,48,61,48,80,80,59,92,15,70,93,92}, new int[]{90,48,17,83,48,59,52,80,50,68,50,22,48,48,75,49,77,30,72,26,15,54,88,88,5});
		System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));
	}

}