package practice2022.algo;

import org.junit.Assert;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", rw.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            if ( i == chars.length || chars[i] == ' ') {
                reverseString(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars);

    }

    public void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
        }
    }
}
