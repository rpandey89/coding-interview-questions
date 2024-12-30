package practice2022.ds.arrays;

public class MaxSumContiguousSubArray {
    public static void main(String[] args) {
        // Array initializer won't work on re-assignment
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSumContiguousSubArray mscsa = new MaxSumContiguousSubArray();
        System.out.println(mscsa.maxSubArray(nums));
        int[] nums1 = {1};
        System.out.println(mscsa.maxSubArray(nums1));
        int[] nums2 = {5,4,-1,7,8};
        System.out.println(mscsa.maxSubArray(nums2));
    }

    // Kadane's Algo
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        int currentMaxSum = Integer.MIN_VALUE;
//        int totalSum = 0;
//		/*
//		for(int i = 0; i < nums.length; i++) {
//		    totalSum = totalSum + nums[i];
//			if (nums[i] > currentMaxSum && nums[i] > totalSum) {
//				totalSum = 0;
//			}
//			currentMaxSum = Math.max(totalSum, currentMaxSum);
//		}
//		*/
//        for (int num: nums) {
//            totalSum = Math.max(num, totalSum + num);
//            currentMaxSum = Math.max(totalSum, currentMaxSum);
//        }
//        return currentMaxSum;
        // runtime of 1 ms
        int previousSum = nums[0], currentSum = nums[0];
        for(int i=1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            previousSum = Math.max(currentSum, previousSum);
        }
        return previousSum;
    }
}
