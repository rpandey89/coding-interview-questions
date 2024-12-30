package practice2022.algo;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsert si = new SearchInsert();
        System.out.println(si.searchInsert(nums, 5));
        System.out.println(si.searchInsert(nums, 2));
        System.out.println(si.searchInsert(nums, 7));
    }

    public int searchInsert(int[] nums, int target) {
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
        return end + 1;
    }
}
