package practice2024;

// https://leetcode.com/problems/single-number/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int a = 0;
        for(int el: nums) {
            a = a ^ el;
        }
        return a;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(new int[]{2,2,1}));
        System.out.println(sn.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(sn.singleNumber(new int[]{1}));
    }

}
