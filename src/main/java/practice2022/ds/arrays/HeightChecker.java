package practice2022.ds.arrays;

import java.util.stream.IntStream;
import java.util.Arrays;

class HeightChecker {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4,2,1,3};
        System.out.println(heightChecker(nums));

        nums = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(heightChecker(nums));

    }

    public static int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        /*
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int indices = 0;
        for (int i = 0; i < heights.length; i++) {
        	if(heights[i] != expected[i]) {
        		indices++;
        	}
        }
        */

        // using counting sort algorithm for O(N)
        int[] heightCount = new int[101]; // as max height is 100
        for (int i = 0; i < heights.length; i++) {
            heightCount[heights[i]] += 1;
        }

        int countIndex = 0;
        int indices = 0;
        for (int i = 0; i < heights.length; i++) {
            while(heightCount[countIndex] == 0) {
                countIndex++;
            }

            if(heights[i] != countIndex) {
                indices++;
            }
            heightCount[countIndex] -= 1;

        }

        return indices;

    }

    private static void printArray(int[] nums) {
        IntStream
                .range(0, nums.length)
                .forEach(i -> {
                    if (i == 0) {
                        System.out.print("[ ");
                    }
                    System.out.print(nums[i]);
                    if (i < nums.length - 1) {
                        System.out.print(", ");
                    } else {
                        System.out.print("]\n");
                    }

                });

    }


}