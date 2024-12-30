package practice2022.ds.arrays;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Follow-up Questions
 *
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *         We can use either Approach 2 or Approach 3, dropping the sort of course. It will give us linear time and constant memory complexity.
 *
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *         Approach 1 is a good choice here as we use a hash map for the smaller array.
 *
 *     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 *         If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.
 *
 *         If neither of the arrays fit into the memory, we can apply some partial processing strategies:
 *
 *             Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).
 *
 *             Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
 */

public class IntersectionTwoArrays {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        IntersectionTwoArrays ita = new IntersectionTwoArrays();
        ita.printResult(ita.intersect(nums, nums2));

        ita.printResult(ita.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));

        ita.printResult(ita.intersectImproved1(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        ita.printResult(ita.intersectImproved1(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));

        ita.printResult(ita.intersectImproved2(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        ita.printResult(ita.intersectImproved2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> numCount1 = new HashMap<>();
        for (int num : nums1) {
            numCount1.put(num, numCount1.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> numCount2 = new HashMap<>();

        for (int num : nums2) {
            numCount2.put(num, numCount2.getOrDefault(num, 0) + 1);
        }

        Set<Integer> commonKeys = numCount2.keySet();
        commonKeys.retainAll(numCount1.keySet());

        List<Integer> commonNumbers = new ArrayList<>();
        for (int key : commonKeys) {
            int count = Math.min(numCount2.get(key), numCount1.get(key));
            while (count > 0) {
                commonNumbers.add(key);
                count--;
            }
        }

        int[] result = new int[commonNumbers.size()];
        int j = 0;
        for (Integer num : commonNumbers) {
            result[j++] = num;
        }
        return result;
    }

    public int[] intersectImproved1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> numCount = new HashMap<>();
        // need to do this to keep numCount as small as possible
        int[] smallerArray = nums1.length <= nums2.length ? nums1 : nums2;
        int[] greaterArray = nums1.length > nums2.length ? nums1 : nums2;
        for (int num : smallerArray) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        List<Integer> commonNumbers = new ArrayList<>();
        for (int num : greaterArray) {
            if (numCount.containsKey(num)) {
                int count = numCount.get(num);
                if (count > 0) {
                    commonNumbers.add(num);
                }
                numCount.put(num, count - 1);
            }
        }

        int[] result = new int[commonNumbers.size()];
        int i = 0;
        for (Integer num : commonNumbers) {
            result[i++] = num;
        }
        return result;
    }
    public int[] intersectImproved2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }

            if (nums2[j] < nums1[i]) {
                j++;
                continue;
            }

            nums1[k++] = nums1[i++];
            j++;
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }


    public void printResult(int[] result) {
        IntStream.range(0, result.length)
                .forEach(i -> {
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
