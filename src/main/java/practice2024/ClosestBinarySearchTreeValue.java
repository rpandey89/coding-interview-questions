package practice2024;


// https://leetcode.com/problems/closest-binary-search-tree-value/

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        double currentDiff = Math.abs(root.val - target);
        int nearest = 0;
        if (root.val > target) {
            nearest = closestValue(root.left, target);
        } else {
            nearest = closestValue(root.right, target);
        }

        double nearestDiff = Math.abs(nearest - target);
        if (currentDiff == nearestDiff) {
            return root.val < nearest ? root.val : nearest;
        } else {
            return currentDiff < nearestDiff ? root.val : nearest;
        }
    }

    class TreeNode {
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
