package practice2024;


// https://leetcode.com/problems/valid-word-abbreviation/
public class WordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
        int pointer=0;
        int pointer1=0;
        while(pointer < word.length() && pointer1 < abbr.length()) {
            if(!Character.isDigit(abbr.charAt(pointer1))) {
                if(abbr.charAt(pointer1) != word.charAt(pointer)) {
                    return false;
                }
                pointer++;
                pointer1++;
                continue;
            }
        	if(abbr.charAt(pointer1) == '0') {
        		return false;
        	}

        	StringBuilder sb = new StringBuilder();
        	while(pointer1 < abbr.length() && Character.isDigit(abbr.charAt(pointer1))) {
        		sb.append(abbr.charAt(pointer1));
        		pointer1++;
        	}

        	pointer = pointer + Integer.parseInt(sb.toString());
        }
        return pointer == word.length() && pointer1 == abbr.length();
    }

    public static void main(String[] args) {
    	WordAbbreviation wabbv = new WordAbbreviation();
    	System.out.println(wabbv.validWordAbbreviation("substitution", "s10n"));
    	System.out.println(wabbv.validWordAbbreviation("substitution", "sub5u4"));
        System.out.println(wabbv.validWordAbbreviation("substitution", "sub4u4"));
        System.out.println(wabbv.validWordAbbreviation("substitution", "s55n"));
    	System.out.println(wabbv.validWordAbbreviation("substitution", "12"));
    }

}


