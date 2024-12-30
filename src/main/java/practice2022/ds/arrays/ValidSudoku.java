package practice2022.ds.arrays;

import org.junit.Assert;

class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Assert.assertTrue(vs.isValidSudoku(board));
        char[][] board1 = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Assert.assertFalse(vs.isValidSudoku(board1));
    }

    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int[][] boxes = new int[m/3][n/3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int element = board[i][j];
                int bitmask = 1 << (element - 48);
                if ((rows[i] & bitmask) == bitmask) {
                    return false;
                } else {
                    rows[i] = rows[i] | bitmask;
                }

                if ((cols[j] & bitmask) == bitmask) {
                    return false;
                } else {
                    cols[j] = cols[j] | bitmask;
                }

                if ((boxes[i/3][j/3] & bitmask) == bitmask) {
                    return false;
                } else {
                    boxes[i/3][j/3] = boxes[i/3][j/3] | bitmask;
                }

            }
        }

        return true;
    }
}
