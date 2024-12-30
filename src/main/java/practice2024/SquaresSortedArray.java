package practice2024;

import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class SquaresSortedArray {

	public int[] sortedSquares(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[1];
		}

		int[] result = new int[nums.length];
		int start = 0;
		int end = nums.length - 1;
		int resIndex = nums.length - 1;
		while (start <= end) {
            int square1 = nums[start] * nums[start];
            int square2 = nums[end] * nums[end];
			if(square1 > square2) {
				result[resIndex] = square1;
				start++;
			} else {
				result[resIndex] = square2;
				end--;
			}
			resIndex--;
		}
		return result;
	}


	public static void main(String[] args) {
		SquaresSortedArray sqa = new SquaresSortedArray();
		int[] result = sqa.sortedSquares(new int[]{-4,-1,0,3,10});
		System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));

		result = sqa.sortedSquares(new int[]{-7,-3,2,3,11});
		System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));

	}

}
