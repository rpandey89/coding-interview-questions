package practice2022.ds.arrays;

class MaxConsecutive1s {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutive1s(nums));
    }

    public static int findMaxConsecutive1s(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max1s = 0;
        int currentMax1s = 0;
        for (int i : nums) {
            if (i == 1) {
                currentMax1s += 1;
            } else {
                max1s = Math.max(currentMax1s, max1s);
                currentMax1s = 0;
            }
        }
        return Math.max(currentMax1s, max1s);
    }
}
