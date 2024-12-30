package practice2024;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class TreeTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		do {
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				result.add(current.val);
				current = current.right;
			}
		} while (!stack.empty() || current != null);
		return result;
	}

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        do {
            if (current != null) {
                result.add(current.val);
                stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
            }
        } while (current != null || !stack.empty());
        return result;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        do {
            if (current != null) {
                stack.push(current);
                stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
                if (current != null) {
                    result.add(current.val);
                }
            }
        } while(!stack.empty() || current != null);
        return result;
    }


	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	}

}