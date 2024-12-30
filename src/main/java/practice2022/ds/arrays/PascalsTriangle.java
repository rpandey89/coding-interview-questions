package practice2022.ds.arrays;

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pst = new PascalsTriangle();
        System.out.println(pst.generate(5));
        System.out.println(pst.generate(6));
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        int i = 1;
        while (i < numRows) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int j = 1;
            List<Integer> prevRow = result.get(i-1);
            while (j <= i - 1) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
                j++;
            }
            row.add(1);
            result.add(row);
            i++;
        }

        return result;
    }

    public void printResult(List<List<Integer>> result) {
        IntStream.range(0, result.size())
                .forEach(i -> {
                    if (i == 0) {
                        System.out.print("[");
                    }
                    IntStream.range(0, result.get(i).size())
                            .forEach(j -> {
                                if (j == 0) {
                                    System.out.print("[");
                                }
                                System.out.print(result.get(i).get(j));
                                if (j < result.get(i).size() - 1) {
                                    System.out.print(",");
                                } else {
                                    System.out.print("]");
                                }

                            });
                    if (i < result.size()- 1) {
                        System.out.print(",");
                    } else {
                        System.out.println("]");
                    }
                });
    }
}