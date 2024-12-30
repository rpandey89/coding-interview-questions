package practice2024;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
 */
public class TwoStringsEqual {

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String subStr: word1) {
        	sb.append(subStr);
        }

        StringBuilder sb1 = new StringBuilder();
        for (String subStr: word2) {
        	sb1.append(subStr);
        }

        String text = sb.toString();
        String text1 = sb1.toString();

        return text.equals(text1);
    }

	public static void main(String[] args) {
        TwoStringsEqual tse = new TwoStringsEqual();
        System.out.println(tse.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(tse.arrayStringsAreEqual(new String[]{"ac", "b"}, new String[]{"a", "bc"}));
        System.out.println(tse.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));

	}

}
