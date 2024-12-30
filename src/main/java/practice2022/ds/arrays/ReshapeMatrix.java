package practice2022.ds.arrays;

import java.util.stream.IntStream;

public class ReshapeMatrix {

    public static void main(String[] args) {
        ReshapeMatrix rsm = new ReshapeMatrix();
        int[][] result = rsm.matrixReshape2(new int[][]{{1,2}, {3,4}}, 2, 2);
        rsm.printResult(result);
        result = rsm.matrixReshape2(new int[][]{{1,2}, {3,4}}, 2, 4);
        rsm.printResult(result);
        result = rsm.matrixReshape2(new int[][]{{1,2,3}, {3,4,5}}, 3, 2);
        rsm.printResult(result);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        if (m == 0 || (m == r && c == mat[0].length) || (r *c != m * mat[0].length)) {
            return mat;
        }
        int n = mat[0].length;
        int[] tempArray = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tempArray[i*n+j] = mat[i][j];
            }
        }

        int[][] reshapedMatrix = new int[r][c];
        for (int i = 0; i < tempArray.length; i++) {
            reshapedMatrix[i/c][i%c] = tempArray[i];
        }
        return reshapedMatrix;
    }

    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length;
        if (m == 0 || (m == r && c == mat[0].length) || (r *c != m * mat[0].length)) {
            return mat;
        }
        int n = mat[0].length;
        int[][] reshapedMatrix = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshapedMatrix[x][y++] = mat[i][j];
                if (y == c) {
                    y = 0;
                    x++;
                }
            }
        }
        return reshapedMatrix;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        if (m == 0 || (m == r && c == mat[0].length) || (r*c != m * mat[0].length)) {
            return mat;
        }
        int[][] reshapedMatrix = new int[r][c];
        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                reshapedMatrix[k/c][k%c] = mat[i][j]; // x = idx / cols y = idx % cols to convert from 1-d indices to 2-d indices
                k++;
            }
        }
        return reshapedMatrix;
    }

    public void printResult(int[][] result) {
        IntStream.range(0, result.length)
                .forEach(i -> {
                    if (i == 0) {
                        System.out.print("[");
                    }
                    IntStream.range(0, result[0].length)
                            .forEach(j -> {
                                if (j == 0) {
                                    System.out.print("[");
                                }
                                System.out.print(result[i][j]);
                                if (j < result[0].length - 1) {
                                    System.out.print(",");
                                } else {
                                    System.out.print("]");
                                }

                            });
                    if (i < result.length - 1) {
                        System.out.print(",");
                    } else {
                        System.out.println("]");
                    }
                });
    }
}
