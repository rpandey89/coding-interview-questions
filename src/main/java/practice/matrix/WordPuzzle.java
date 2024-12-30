package practice.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordPuzzle {
    private static final Set<String> expectedWords = new HashSet<>(Arrays.asList("mad", "am", "dam", "jam"));
    public static void main(String[] args) {
        /*
        ABCD
        EFGH
        IJKL
        MNOP
         */
        //O(N*N*4*3^16-1)
        //O(N^2*3^15)
        char[][] input = new char[][]{{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'd', 'k', 'l'}, {'m', 'a', 'j', 'p'}};
        int[][] freq = new int[input.length][input[0].length];
        Set<String> words = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                boolean[][] visited = new boolean[input.length][input[0].length];
                findWords(input, i, j, visited, "", words, freq);
            }
        }
        words.forEach(System.out::println);
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[0].length; j++) {
                System.out.print(freq[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    private static void findWords(char[][] input, int row, int col, boolean[][] visited, String currentText, Set<String> words, int[][] freq) {
        if (row < 0 || row >= input.length || col < 0 || col >= input[0].length || visited[row][col]) {
            return;
        }
        freq[row][col] = freq[row][col] + 1;
        String newText = currentText + input[row][col];
        visited[row][col] = true;
        if(expectedWords.contains(newText)) {
            words.add(newText);
        }
        findWords(input, row + 1, col, visited, newText, words, freq);
        findWords(input, row - 1, col, visited, newText, words, freq);
        findWords(input, row, col + 1, visited, newText, words, freq);
        findWords(input, row, col - 1, visited, newText, words, freq);
        visited[row][col] = false;
    }
}
