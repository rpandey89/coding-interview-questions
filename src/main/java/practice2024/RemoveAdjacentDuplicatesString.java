package practice2024;

import java.util.Deque;
import java.util.ArrayDeque;


// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/


public class RemoveAdjacentDuplicatesString {

	public String removeDuplicates(String s) {
		Deque<Character> elements = new ArrayDeque<>();
		for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
			if (!elements.isEmpty()) {
				char top = elements.peek();
				if (top == c) {
					elements.pop();
					continue;
				}
			}
			elements.push(c);
		}

        StringBuilder result = new StringBuilder();

        while(!elements.isEmpty()) {
            result.append(elements.removeLast());
        }

        return result.toString();
	}

	public static void main(String[] args) {
		RemoveAdjacentDuplicatesString rads = new RemoveAdjacentDuplicatesString();
		System.out.println(rads.removeDuplicates("abbaca"));
		System.out.println(rads.removeDuplicates("azxxzy"));
	}

}
