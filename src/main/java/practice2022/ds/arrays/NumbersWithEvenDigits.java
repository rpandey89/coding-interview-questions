package practice2022.ds.arrays;

public class NumbersWithEvenDigits {

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i : nums) {
            int digits = findDigitsUsingLog(i);
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int findDigits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static int findDigitsUsingLog(int num) {
        return (int) Math.floor(Math.log10(num)) + 1;
    }
}
