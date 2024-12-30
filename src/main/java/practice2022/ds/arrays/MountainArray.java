package practice2022.ds.arrays;

import java.util.stream.IntStream;


class MountainArray {

    public static void main(String[] args) {
        int[] nums = {2,1};
        printArray(nums);
        System.out.println(validMountainArray(nums));


        nums = new int[]{3,5,5};
        printArray(nums);
        System.out.println(validMountainArray(nums));

        nums = new int[]{0,3,2,1};
        printArray(nums);
        System.out.println(validMountainArray(nums));

        nums = new int[]{2,0,2};
        printArray(nums);
        System.out.println(validMountainArray(nums));

        nums = new int[]{0,1,2,1,2};
        printArray(nums);
        System.out.println(validMountainArray(nums));


        nums = new int[]{2, 0, 1, 2, 3, 2};
        printArray(nums);
        System.out.println(validMountainArray(nums));

        nums = new int[]{0, 2, 1, 3, 2, 3};
        printArray(nums);
        System.out.println(validMountainArray(nums));

    }

    public static boolean validMountainArray(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }

        int i = 0;
        int capacity = nums.length - 1;
        while (i < capacity && nums[i] < nums[i+1]) {
            i++;
        }

        if (i == 0 || i == capacity) {
            return false;
        }

//         while (i < capacity && nums[i] > nums[i + 1]) {
//             i++;
//         }

//         return i == capacity;
        int j = capacity;
        while (j > 0 && nums[j] < nums[j - 1]) {
            j--;
        }
        return i == j;

//         int[] flag = {0,0};

//         for(int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i+1]) {
//                 return false;
//             }


//             if ((i == 0 || (flag[0] == 1 && flag[1] == 0)) && nums[i] < nums[i+1]) {
//                 flag[0] = 1;
//             } else if (flag[0] == 1 && nums[i] > nums[i+1]) {
//                 flag[1] = 1;
//             } else {
//                 flag[0] = -1;
//                 flag[1] = -1;
//             }
//         }
//         return flag[0] == 1 && flag[1] == 1;


    }

    private static void printArray(int[] nums) {
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
