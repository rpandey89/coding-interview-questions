package practice2024;


/**
 * https://leetcode.com/problems/range-sum-of-bst/description/
 */
public class RangeSumBST {

	public static void main(String[] args) {


	}

	private static int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		if (low == root.val && root.val == high) {
			return root.val;
		}

		// range in left sub-tree
		if (root.val > high && root.val > low) {
			return rangeSumBST(root.left, low, high);
		}

		// range in right sub-tree
		if (root.val < high && root.val < low) {
			return rangeSumBST(root.right, low, high);
		}

		int left = 0;
		if (root.val > low) {
			left = rangeSumBST(root.left, low, root.val);
		}

		int right = 0;
		if (root.val < high) {
			right = rangeSumBST(root.right, root.val, high);
		}

		return root.val + left + right;
	}



	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
		 	this.val = val;
		  	this.left = left;
		 	this.right = right;
		}
  	}

}