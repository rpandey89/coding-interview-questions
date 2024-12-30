package practice2022.algo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(nums, 9));
        System.out.println(bs.search(nums, 2));
    }

//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        return subSearch(nums, target, 0, nums.length - 1);
//    }
//
//    private int subSearch(int[] nums, int target, int start, int end) {
//        // base condition
//        if (start > end) {
//            return -1;
//        }
//
//        int mid = start + ((end - start) / 2);
//        if (nums[mid] == target) {
//            return mid;
//        }
//        // search right
//        else if (nums[mid] < target) {
//            return subSearch(nums, target, mid + 1, end);
//        }
//        // search left
//        return subSearch(nums, target, start, mid - 1);
//    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
