package practice2024;


// https://leetcode.com/problems/diameter-of-binary-tree/
public class TreeDiameter {

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

	public class DiameterData {
        int longestPath;
        int diameter;

        DiameterData(int longestPath, int diameter) {
            this.longestPath = longestPath;
            this.diameter = diameter;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        DiameterData diameterData = diameterOfBinaryTreeHelper(root);
        return diameterData.diameter;
    }

    private DiameterData diameterOfBinaryTreeHelper(TreeNode root) {

    	if(root == null) {
    		return new DiameterData(0, 0);
    	}

    	DiameterData left = diameterOfBinaryTreeHelper(root.left);

		DiameterData right = diameterOfBinaryTreeHelper(root.right);

		int diameter = Math.max(left.longestPath + right.longestPath, Math.max(left.diameter, right.diameter));

		int longestPath = Math.max(left.longestPath, right.longestPath) + 1;
		return new DiameterData(longestPath, diameter);
    }

}


