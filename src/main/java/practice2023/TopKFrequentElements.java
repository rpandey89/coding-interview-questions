package practice2023;

import java.util.stream.IntStream;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        printArray(topKFrequent(arr, 2));
        int[] arr1 = {1};
        printArray(topKFrequent(arr1, 1));
        int[] arr2 = {4,3,4,2,3,1};
        printArray(topKFrequent(arr2, 2));
        int[] arr3 = {4,3,4,2,3,1};
        printArray(topKFrequent(arr3, 3));
    }

    private static int[] topKFrequent(int[] input, int k) {
        Map<Integer, Integer> elementFreq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int el: input) {
            int freq = elementFreq.getOrDefault(el, 0) + 1;
            elementFreq.put(el, freq);
            if (freq == k) {
                result.add(el);
            }
        }
        return result.stream().mapToInt(el -> el).toArray();
    }

    private static void printArray(int[] result) {

        IntStream.range(0, result.length)
                .forEach(i -> {
                    if (i == 0) {
                        System.out.print("\n{");
                    }
                    System.out.print(result[i]);
                    if (i == result.length - 1) {
                        System.out.print("}");
                    } else {
                        System.out.print(",");
                    }
                });
    }

}
