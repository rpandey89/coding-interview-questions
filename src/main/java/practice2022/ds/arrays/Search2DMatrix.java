package practice2022.ds.arrays;

import org.junit.Assert;

public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix s2dm = new Search2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Assert.assertTrue(s2dm.searchMatrix(matrix, 3));

        Assert.assertFalse(s2dm.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int cols = matrix[0].length;
        int start = 0, end = ((matrix.length) * (matrix[0].length) - 1);
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int midEl = matrix[mid / cols][mid % cols]; // [idx / cols] [idx % cols] to convert from 1-d indices to 2-d indices
            // for converting 2-d indices to 1-d indices [i * n + j]

            if (midEl == target) {
                return true;
            }

            if (midEl < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}