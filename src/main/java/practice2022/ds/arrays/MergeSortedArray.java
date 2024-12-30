package practice2022.ds.arrays;
import java.util.stream.IntStream;

/**
 * Interview Tip: Whenever you're trying to solve an array problem in-place,
 * always consider the possibility of iterating backwards instead of forwards through the array.
 * It can completely change the problem, and make it a lot easier.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        msa.merge(nums1, m, nums2, n);
        msa.printResult(nums1);
        int[] nums3 = {0};
        int[] nums4 = {};
        m = 1;
        n = 0;
        msa.merge(nums3, m, nums4, n);
        msa.printResult(nums3);
        int[] nums5 = {0};
        int[] nums6 = {1};
        m = 0;
        n = 1;
        msa.merge(nums5, m, nums6, n);
        msa.printResult(nums5);
        int[] nums7 = {4,5,6,0,0,0};
        int[] nums8 = {1,2,3};
        m = 3;
        n = 3;
        msa.merge(nums7, m, nums8, n);
        msa.printResult(nums7);
    }

    // doesn't work because it is complex to apply the usual merge sort and is buggy
    // either of the arrays are not set properly
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        int i = 0;
//        int j = 0;
//        while (i < m && j < n) {
//            if (nums2[j] < nums1[i]) {
//                int temp = nums1[i];
//                nums1[i] = nums2[j];
//                nums2[j] = temp;
//            }
//            j++;
//            i++;
//        }
//
//        j = 0;
//        while(j < n) {
//            nums1[i] = nums2[j];
//            j++;
//            i++;
//        }
//        }
    // Time complexity: O(m + n) Space: O(m)
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums1Copy = Arrays.copyOf(nums1, m);
//        int i = 0;
//        int j = 0;
//        for (int k = 0; k < m + n; k++) {
//            if (j >= n || (i < m && nums1Copy[i] < nums2[j])) {
//                nums1[k] = nums1Copy[i];
//                i++;
//            } else {
//                nums1[k] = nums2[j];
//                j++;
//            }
//        }
//
//    }


    // Time complexity: O(m + n) Space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0) {
                break;
            }
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    // O(m + n) same to above but a little more code
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // early return if either first array is empty or second array is empty
        if (nums1.length == 0) {
            return;
        }
        if (nums2.length == 0 || n == 0) {
            return;
        }

        // add rest of the elements from second array if any
        int end = m + n - 1;
        int start1 = m - 1;
        int start2 = n - 1;
        while(start1 >= 0 && start2 >= 0) {
            if (nums1[start1] >= nums2[start2]) {
                nums1[end] = nums1[start1--];
            } else {
                nums1[end] = nums2[start2--];
            }
            end--;
        }

        while(start2 >= 0) {
            nums1[end] = nums2[start2--];
            end--;
        }
    }

    private void printResult(int[] nums) {
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