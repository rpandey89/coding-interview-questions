package practice2024;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPlaindromeII {
    private boolean checkPalindrome(String s, int start, int end, int attempt) {
        if (attempt > 1) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return checkPalindrome(s, start + 1, end, attempt+1) || checkPalindrome(s, start, end - 1, attempt+1);
            }
            end--;
            start++;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        return checkPalindrome(s, start, end, 0);
    }

    public static void main(String[] args) {
        ValidPlaindromeII vpndrm = new ValidPlaindromeII();
        System.out.println(vpndrm.validPalindrome("aba"));
        System.out.println(vpndrm.validPalindrome("abca"));
        System.out.println(vpndrm.validPalindrome("abc"));
        System.out.println(vpndrm.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(vpndrm.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
