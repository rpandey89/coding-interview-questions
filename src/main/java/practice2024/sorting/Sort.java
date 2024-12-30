package practice2024.sorting;

import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[] {2,6,1,3,9};
        selectionSort(nums);
        printArray(nums);
        System.out.println(bubbleSort(Arrays.stream(new int[]{2,6,1,3,9}).boxed().collect(Collectors.toList())));
        System.out.println(insertionSort(Arrays.stream(new int[]{2,6,1,3,9,0}).boxed().collect(Collectors.toList())));
    }

    // can put maximum also instead of minimum
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIndex] = temp;
        }
    }

    private static List<Integer> bubbleSort(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        //return Arrays.stream(arr).boxed().collect(Collectors.toList());
        ArrayList<Integer> output = new ArrayList<>();
        Arrays.stream(arr).forEach(output::add);
        return output;
    }

    private static List<Integer> insertionSort(List<Integer> arr) {
        int[] nums = new int[arr.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr.get(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i - 1;
            int temp = nums[i];
            while (left >= 0 && nums[left] > temp) {
                nums[left + 1] = nums[left];
                left--;
            }
            nums[left + 1] = temp;
        }

        // ArrayList<Integer> output = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++) {
        //     output.add(nums[i]);
        // }

        return Arrays.stream(nums).boxed().collect(Collectors.toList());

    }

    private static void printArray(int[] nums) {
        IntStream.range(0, nums.length)
        .forEach(i -> {
            if (i == 0) {
                System.out.print("{");
            }
            System.out.print(nums[i]);
            if (i == nums.length - 1) {
                System.out.print("}\n");
            } else {
                System.out.print(",");
            }
        });
    }
}
