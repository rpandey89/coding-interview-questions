package practice2024;

import java.util.List;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoIntegers {
    public static void main(String[] args) {
        ListNode l1 = createLL(Arrays.asList(2,4,3));
        ListNode l2 = createLL(Arrays.asList(5,6,4));
        ListNode result = addTwoNumLL(l1, l2);
	}

	private static int addTwoNumMath(int num1, int num2) {
		return num1 + num2;
	}

	private static ListNode addTwoNumLL(ListNode l1, ListNode l2) {
		ListNode head = null;
        ListNode prev = null;
		int carry = 0;
		while(l1 != null || l2 != null || carry > 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
			int sum = val1 + val2 + carry;
			int newVal = sum % 10;
			carry = sum / 10;
            ListNode next = new ListNode(newVal);
			if (head == null) {
				head = next;
				prev = head;
			} else {
				prev.next = next;
				prev = next;
			}
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
        return head;

	}

    private static ListNode createLL(List<Integer> nums) {
        ListNode head = null, prev = null;
        for(int el: nums) {
            if (head == null) {
                head = new ListNode(el);
                prev = head;
            } else {
                ListNode next = new ListNode(el);
                prev.next = next;
                prev = next;
            }
        }
        return head;
    }


	private static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 	}
}
