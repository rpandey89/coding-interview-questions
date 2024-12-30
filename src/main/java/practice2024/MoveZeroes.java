package practice2024;

import java.util.stream.IntStream;
import java.util.stream.Collectors;



public class MoveZeroes {

	public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int current = 0;
        while(current < nums.length) {
        	if (nums[current] != 0) {
                int temp = nums[zeroIndex];
        		nums[zeroIndex++] = nums[current];
        		nums[current] = temp;
        	}
        	current++;
        }
    }

    public static void main(String[] args) {
    	MoveZeroes mz = new MoveZeroes();
    	int[] nums = new int[]{0,1,0,3,12};
    	mz.moveZeroes(nums);
    	System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
    	nums = new int[]{0,0,1,0,3,5,0};
        mz.moveZeroes(nums);
    	System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));

        nums = new int[]{1,2,3,4};
        mz.moveZeroes(nums);
    	System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));

        nums = new int[]{1};
        mz.moveZeroes(nums);
    	System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));


        nums = new int[]{0,0};
        mz.moveZeroes(nums);
    	System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));

        nums = new int[]{0,0,2};
        mz.moveZeroes(nums);
    	System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));

    }

}
