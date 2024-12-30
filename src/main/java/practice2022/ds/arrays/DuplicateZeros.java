package practice2022.ds.arrays;

class DuplicateZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums);
        for (int i : nums) {
            System.out.print(i);
        }
        nums = new int[]{1, 2, 3};
        System.out.println("\n");
        duplicateZeros(nums);
        for (int i: nums) {
            System.out.print(i);
        }
    }
    public static void duplicateZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // count total number of elements that can be fit in the array
        int numElements = 0;
        int duplicatedZeros = 0;
        int capacity = nums.length;
        for (int i = 0; numElements < capacity; i++) {
            if (nums[i] == 0) {
                numElements++;
                if (numElements == capacity) {
                    // as this 0 cannot be duplicated just copy it over to the end
                    nums[capacity - 1] = 0;
                    // reduce the total number of elements to be shifted as we have already moved 1 element
                    numElements--;
                    break;
                }
                // as we haven't reached capacity so we can duplicate this zero
                duplicatedZeros++;
            }
            numElements++;
        }

        int end = numElements - 1;
        int start = end - duplicatedZeros;
        // move all the elements to the right and duplicating zero
        while (duplicatedZeros > 0) {
            if (nums[start] == 0) {
                nums[end--] = 0;
                duplicatedZeros--;
            }
            nums[end--] = nums[start--];
        }
    }

//    public static void duplicateZeros(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        // for (int i = 0; i < nums.length; i++) {
//        //     if (nums[i] == 0 && i < nums.length - 1) {
//        //         shiftElementsRight(nums, i + 1);
//        //         nums[i++] = 0;
//        //     }
//        // }
//        // count number of elements that can be fit in the array and that can be trimmed
//        int numElements = 0;
//        int duplicatedZeros = 0;
//        // {1, 2, 3, 4, 5, 0}
//        // {1, 2, 3, 0, 0, 4}
//        // {1, 0, 2, 3, 0, 4, 5, 0}
//        // {0, 0, 0, 0}
//        for (int i = 0; numElements < nums.length; i++) {
//            if (nums[i] == 0) {
//                numElements++;
//                if (numElements == nums.length) {
//                    // as this 0 cannot be duplicated just copy it over to the end
//                    // and copy rest of the elements after that
//                    nums[nums.length - 1] = 0;
//                    numElements--;
//                    break;
//                }
//                duplicatedZeros++;
//            }
//            numElements++;
//        }
//
//
//        int end = numElements - 1;
//        int start = end - duplicatedZeros;
//        // move all the elements to the right and duplicating zero
//        while (duplicatedZeros > 0) {
//            if (nums[start] == 0) {
//                nums[end--] = 0;
//                duplicatedZeros--;
//            }
//            nums[end--] = nums[start--];
//        }
//    }

    private void shiftElementsRight(int[] nums, int index) {
        for (int i = nums.length - 1; i >= index; i--) {
            nums[i] = nums[i-1];
        }
    }

}
